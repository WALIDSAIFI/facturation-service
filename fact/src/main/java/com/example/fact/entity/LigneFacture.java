package com.example.fact.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "lignes_facture")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LigneFacture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer quantite;

    @Column(nullable = false)
    private BigDecimal prixUnitaireHT;

    @Column(nullable = false)
    private BigDecimal tauxTVA;

    @ManyToOne
    @JoinColumn(name = "facture_id", nullable = false)
    private Facture facture;
}
