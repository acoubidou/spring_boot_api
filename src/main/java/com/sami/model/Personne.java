package com.sami.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "personne_id")
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

    @ManyToMany
    @JoinTable(
            name = "personne_vehicule",
            joinColumns = @JoinColumn(name = "personne_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicule_id")
    )
    private List<Vehicule> vehicules;
}
