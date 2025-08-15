package com.example.fact.repository;

import com.example.fact.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
    Optional<Client> findByEmail(String email);
    
    Optional<Client> findBySiret(String siret);
    
    boolean existsByEmail(String email);
    
    boolean existsBySiret(String siret);
}
