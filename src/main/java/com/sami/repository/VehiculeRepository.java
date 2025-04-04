package com.sami.repository;

import com.sami.model.Vehicule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends CrudRepository<Vehicule, Integer> {
}
