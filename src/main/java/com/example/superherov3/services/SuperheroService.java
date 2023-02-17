package com.example.superherov3.services;
import com.example.superherov3.model.Superhero;
import com.example.superherov3.repositories.SuperheroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuperheroService {
    private final SuperheroRepository superheroRepository;

    public SuperheroService(){
        this.superheroRepository = new SuperheroRepository();

    }
    public List<Superhero> getSuperheroAll(){
        return superheroRepository.getHeros();
    }

    public ArrayList<Superhero> getSuperhero(String name) {
        return superheroRepository.searchByAlias(name);
    }

    public void addSuperhero(Superhero superhero) {
        superheroRepository.addSuperhero(superhero);
    }

    public ArrayList<Superhero> searchAlias(String name) {
        return superheroRepository.searchByAlias(name);
    }

    public void editSuperhero(String name, Superhero superhero) {
        superheroRepository.replaceSuperhero(name, superhero);
    }

    public void deleteSuperhero(Superhero superhero) {
        superheroRepository.deleteSuperhero(superhero);
    }
}
