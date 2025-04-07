package com.sami.controller;

import com.sami.model.Personne;
import com.sami.model.Vehicule;
import com.sami.service.PersonneService;
import com.sami.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonneController {

    @Autowired
    private PersonneService personneService;
    @Autowired
    private VehiculeService vehiculeService;

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

    @PostMapping("/personne/{personneId}/vehicule/{vehiculeId}")
    public ResponseEntity<?> associerVehiculeAPersonne(@PathVariable int personneId, @PathVariable int vehiculeId) {
        Optional<Personne> personneOptional = personneService.getPersonne(personneId);
        Optional<Vehicule> vehiculeOptional = vehiculeService.getVehicule(vehiculeId);

        if (personneOptional.isEmpty() || vehiculeOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Personne ou Véhicule non trouvé.");
        }

        Personne personne = personneOptional.get();
        Vehicule vehicule = vehiculeOptional.get();

        personne.getVehicules().add(vehicule);
        vehicule.getPersonnes().add(personne);

        personneService.savePersonne(personne);
        vehiculeService.saveVehicule(vehicule);

        return ResponseEntity.status(HttpStatus.OK).body("Véhicule associé à la personne.");
    }
    @DeleteMapping("/personne/{personneId}/vehicule/{vehiculeId}")
    public ResponseEntity<?> removeVehiculeFromPersonne(@PathVariable("personneId") int personneId, @PathVariable("vehiculeId") int vehiculeId) {
        Optional<Personne> personneOptional = personneService.getPersonne(personneId);
        if (personneOptional.isPresent()) {
            Personne personne = personneOptional.get();
            Optional<Vehicule> vehiculeOptional = vehiculeService.getVehicule(vehiculeId);

            if (vehiculeOptional.isPresent()) {
                Vehicule vehicule = vehiculeOptional.get();

                personne.getVehicules().remove(vehicule);

                vehicule.getPersonnes().remove(personne);

                personneService.savePersonne(personne);
                vehiculeService.saveVehicule(vehicule);

                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicule not found");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Personne not found");
        }
    }


}
