package com.example.fact.controller;

import com.example.fact.entity.Facture;
import com.example.fact.service.FactureService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/factures")
public class FactureController {

    private final FactureService factureService;

    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }

    @GetMapping
    public List<Facture> getAllFactures() {
        return factureService.getAllFactures();
    }

    @GetMapping("/{id}")
    public Facture getFactureById(@PathVariable Long id) {
        return factureService.getFactureById(id);
    }

    @GetMapping("/client/{clientId}")
    public List<Facture> getFacturesByClient(@PathVariable Long clientId) {
        return factureService.getFacturesByClient(clientId);
    }

    @GetMapping("/date/{date}")
    public List<Facture> getFacturesByDate(@PathVariable String date) {
        return factureService.getFacturesByDate(LocalDate.parse(date));
    }

    @PostMapping("/{clientId}")
    public Facture createFacture(@PathVariable Long clientId, @RequestBody Facture facture) {
        return factureService.createFacture(clientId, facture);
    }
}
