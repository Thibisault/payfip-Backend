package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private BigDecimal montant;
    private long reference;

    private String nom;
    private Timestamp dateCreation;
    private Timestamp dateReglement;

    private Boolean payerOuNon;

    // Constructeur pour initialiser certaines données quand je fais un "new facture"
    public Facture() {
        this.dateCreation = Timestamp.valueOf(LocalDateTime.now()); // Initialise la date de création à la date actuelle.
        this.payerOuNon = false; // Initialise payerOuNon à false.
    }

}
