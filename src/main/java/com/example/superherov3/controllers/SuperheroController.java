package com.example.superherov3.controllers;
import com.example.superherov3.model.Superhero;
import com.example.superherov3.services.SuperheroService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("db")
public class SuperheroController {

    private final SuperheroService superheroService;

    public SuperheroController(){
        this.superheroService = new SuperheroService();
    }
    @GetMapping(path = "/")
    public ResponseEntity<List<Superhero>> allSuperheroes(){
        List<Superhero> superheroes = superheroService.getSuperheroAll();
        return new ResponseEntity<>(superheroes,HttpStatus.OK);
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<List<Superhero>> getSuperhero(@PathVariable String name){
        List<Superhero> superhero = superheroService.getSuperhero(name);
        return new ResponseEntity<>(superhero,HttpStatus.OK);
    }

    @PostMapping(path = "/opret")
    public ResponseEntity<Superhero> addSuperhero(@RequestBody Superhero superhero){
        superheroService.addSuperhero(superhero);
        return new ResponseEntity<>(superhero,HttpStatus.OK);
    }

    @PostMapping(path = "/delete/{name}")
    public ResponseEntity<Superhero> deleteSuperhero(@PathVariable String name){
        Superhero superhero = superheroService.searchAlias(name).get(0);
        superheroService.deleteSuperhero(superhero);
        return new ResponseEntity<>(superhero, HttpStatus.OK);
    }

    @PostMapping(path = "/edit/{name}")
    public ResponseEntity<Superhero> editSuperhero(@RequestBody Superhero superhero, @PathVariable String name){
        superheroService.editSuperhero(name, superhero);
        return new ResponseEntity<>(superhero, HttpStatus.OK);
    }
}
