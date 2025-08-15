package com.example.fact.service;

import com.example.fact.entity.*;
import com.example.fact.repository.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class FactureService {

    private final FactureRepository factureRepository;
    private final ClientRepository clientRepository;

    public FactureService(FactureRepository factureRepository, ClientRepository clientRepository) {
        this.factureRepository = factureRepository;
        this.clientRepository = clientRepository;
    }

    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    public Facture getFactureById(Long id) {
        return factureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Facture introuvable"));
    }

    public Facture createFacture(Long clientId, Facture facture) {
        if (facture.getLignes() == null || facture.getLignes().isEmpty()) {
            throw new RuntimeException("Une facture doit avoir au moins une ligne");
        }

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        facture.setClient(client);
        facture.setDateFacture(LocalDate.now());

        BigDecimal totalHT = BigDecimal.ZERO;
        BigDecimal totalTVA = BigDecimal.ZERO;

        for (LigneFacture ligne : facture.getLignes()) {
            if (ligne.getQuantite() == null || ligne.getPrixUnitaireHT() == null || ligne.getTauxTVA() == null) {
                throw new RuntimeException("Tous les champs des lignes sont obligatoires");
            }

            BigDecimal montantHT = ligne.getPrixUnitaireHT().multiply(BigDecimal.valueOf(ligne.getQuantite()));
            BigDecimal montantTVA = montantHT.multiply(ligne.getTauxTVA().divide(BigDecimal.valueOf(100)));

            totalHT = totalHT.add(montantHT);
            totalTVA = totalTVA.add(montantTVA);

            ligne.setFacture(facture);
        }

        facture.setTotalHT(totalHT);
        facture.setTotalTVA(totalTVA);
        facture.setTotalTTC(totalHT.add(totalTVA));

        return factureRepository.save(facture);
    }

    public List<Facture> getFacturesByClient(Long clientId) {
        return factureRepository.findByClientId(clientId);
    }

    public List<Facture> getFacturesByDate(LocalDate date) {
        return factureRepository.findByDateFacture(date);
    }
}
