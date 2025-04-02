package com.sami.controller;

import com.sami.model.Personne;
import com.sami.repository.PersonneRepository;
import com.sami.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonneController {

    @Autowired
    private PersonneService personneService;

    @GetMapping("/")
    public String home() {
        return "Bienvenue sur l'API!";
    }

    @PostMapping("/personne")
    public Personne createPersonne(@RequestBody Personne personne) {
        return personneService.savePersonne(personne);
    }

    @GetMapping("/personnes")
    public Iterable<Personne> getPersonnes() {
        return personneService.getPersonnes();
    }

    @GetMapping("/personne/{id}")
    public Personne getPersonne(@PathVariable("id") int id) {
        Optional<Personne> personne = personneService.getPersonne(id);
        if (personne.isPresent()) {
            return personne.get();
        } else {
            return null;
        }
    }

    @PutMapping("/personne/{id}")
    public Personne updatePersonne( @PathVariable("id") int id, @RequestBody Personne personne) {
        Optional<Personne> e = personneService.getPersonne(id);
        if (e.isPresent()) {
            Personne current = e.get();

            String personne_nom = personne.getPersonne_nom();
            if (personne_nom != null) {
                current.setPersonne_nom(personne_nom);
            }
            String personne_mail = personne.getPersonne_mail();
            if (personne_mail != null) {
                current.setPersonne_mail(personne_mail);
            }
            personneService.savePersonne(current);
            return current;
        } else {
            return null;
        }
    }

    @DeleteMapping("/personne/{id}")
    public void deletePersonne(@PathVariable("id") int id) {
        personneService.deletePersonne(id);
    }
}
