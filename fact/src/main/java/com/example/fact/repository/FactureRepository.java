package com.example.fact.repository;

import com.example.fact.entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FactureRepository extends JpaRepository<Facture, Long> {
    List<Facture> findByClientId(Long clientId);
    List<Facture> findByDateFacture(LocalDate dateFacture);
}
