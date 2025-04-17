package com.sami.service;

import com.sami.model.Personne;
import com.sami.repository.PersonneRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class PersonneService {
    @Autowired
    private PersonneRepository personneRepository;

    public Optional<Personne> getPersonne(int id) {
        return personneRepository.findById(id);
    }

    public Iterable<Personne> getPersonnes() {
        return personneRepository.findAll();
    }

    public void deletePersonne(int id) {
        personneRepository.deleteById(id);
    }

    public Personne savePersonne(Personne personne) {
        Personne savedPersonne = personneRepository.save(personne);
        return savedPersonne;
    }
}
