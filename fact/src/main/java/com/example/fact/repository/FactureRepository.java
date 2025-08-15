package com.example.fact.repository;

import com.example.fact.entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
    
    List<Facture> findByClientId(Long clientId);
    
   
    Facture findByIdWithClientAndLignes(@Param("id") Long id);
    
  
    List<Facture> findAllWithClient();
}
