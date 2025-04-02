package com.sami.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name= "Personne")
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personne_id")
    private int personne_id;

    @Column(name = "personne_nom")
    private String personne_nom;

    @Column(name = "personne_mail")
    private String personne_mail;
}
