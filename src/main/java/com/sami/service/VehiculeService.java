package com.sami.service;

import com.sami.model.Vehicule;
import com.sami.repository.VehiculeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class VehiculeService {
    @Autowired
    private VehiculeRepository vehiculeRepository;

    public Optional<Vehicule> getVehicule(int id) {
        return vehiculeRepository.findById(id);
    }

    public Iterable<Vehicule> getVehicules() {
        return vehiculeRepository.findAll();
    }

    public void deleteVehicule(int id) {
        vehiculeRepository.deleteById(id);
    }

    public Vehicule saveVehicule(Vehicule vehicule) {
        Vehicule savedVehicule = vehiculeRepository.save(vehicule);
        return savedVehicule;
    }
}
