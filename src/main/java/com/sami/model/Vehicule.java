package com.sami.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "vehicule_id")
@Table(name = "Vehicule")
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicule_id")
    private int vehicule_id;

    @Column(name = "vehicule_marque")
    private String vehicule_marque;

    @Column(name = "vehicule_modele")
    private String vehicule_modele;

    @ManyToMany(mappedBy = "vehicules")
    private List<Personne> personnes;
}
