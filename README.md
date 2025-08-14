# 📄 Facturation Service

## 📌 Description
Ce projet est un **module backend de facturation** développé en **Java 17 / Spring Boot 3**.  
Il permet de gérer des **clients**, d’émettre des **factures** avec leurs **lignes détaillées**, de calculer automatiquement les montants (HT, TVA, TTC) et d’exporter une facture complète au format **JSON**.

Ce module a été conçu pour être intégré dans une plateforme de gestion de projets (type AriMayi).

---

## 🚀 Fonctionnalités
- **Gestion des clients**
  - Créer un client (nom, email, SIRET, date de création)
  - Lister les clients
  - Consulter les détails d’un client

- **Gestion des factures**
  - Créer une facture (client, date, lignes)
  - Chaque ligne contient : description, quantité, prix unitaire HT, taux de TVA
  - Calcul automatique des totaux : **HT, TVA, TTC**
  - Liste et détail des factures

- **Export JSON**
  - Export complet d’une facture en JSON structuré

- **Règles métier**
  - Une facture doit avoir au moins une ligne
  - Aucun champ ne doit être vide
  - Taux de TVA autorisés : `0%`, `5.5%`, `10%`, `20%`

  - Authentification basique avec Spring Security
  - Recherche de factures par client ou date
  - Tests unitaires

---

## 🛠️ Technologies utilisées
- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **H2 Database** (mode développement)
- **PostgreSQL** (mode production)
- **Lombok**
- **Spring Validation**
- **Swagger/OpenAPI** (documentation API)
- **Spring Security** (optionnel)

---

## 📂 Structure du projet



facturation-service/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/
│ │ │ └── example/
│ │ │ └── facturation/
│ │ │ ├── controller/
│ │ │ ├── dto/
│ │ │ ├── entity/
│ │ │ ├── repository/
│ │ │ ├── service/
│ │ │ └── FacturationApplication.java
│ │ └── resources/
│ │ ├── application.yml
│ │ └── data.sql
│ └── test/
│ └── java/
│ └── com/
│ └── example/
│ └── facturation/
└── pom.xml
```
