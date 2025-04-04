package com.sami.controller;

import com.sami.model.Vehicule;
import com.sami.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class VehiculeController {

    @Autowired
    private VehiculeService vehiculeService;


    @PostMapping("/vehicule")
    public Vehicule createVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.saveVehicule(vehicule);
    }

    @GetMapping("/vehicules")
    public Iterable<Vehicule> getVehicules() {
        return vehiculeService.getVehicules();
    }

    @GetMapping("/vehicule/{id}")
    public Vehicule getVehicule(@PathVariable("id") int id) {
        Optional<Vehicule> vehicule = vehiculeService.getVehicule(id);
        if (vehicule.isPresent()) {
            return vehicule.get();
        } else {
            return null;
        }
    }

    @PutMapping("/vehicule/{id}")
    public Vehicule updateVehicule(@PathVariable("id") int id, @RequestBody Vehicule vehicule) {
        Optional<Vehicule> e = vehiculeService.getVehicule(id);
        if (e.isPresent()) {
            Vehicule current = e.get();

            String vehicule_marque = vehicule.getVehicule_marque();
            if (vehicule_marque != null) {
                current.setVehicule_marque(vehicule_marque);
            }
            String vehicule_modele = vehicule.getVehicule_modele();
            if (vehicule_modele != null) {
                current.setVehicule_modele(vehicule_modele);
            }
            vehiculeService.saveVehicule(current);
            return current;
        } else {
            return null;
        }
    }

    @DeleteMapping("/vehicule/{id}")
    public void deleteVehicule(@PathVariable("id") int id) {
        vehiculeService.deleteVehicule(id);
    }
}
