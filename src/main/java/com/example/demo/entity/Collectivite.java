package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Collectivite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private int codeCol;

}
