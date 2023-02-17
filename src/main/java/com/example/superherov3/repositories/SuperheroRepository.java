package com.example.superherov3.repositories;
import com.example.superherov3.model.Superhero;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public class SuperheroRepository {
    public SuperheroRepository() {
        heroes.add(new Superhero("Peter Parker", "Spiderman", "Spider-Power", 1992, 11.21));
        heroes.add(new Superhero("Clark Kent", "Superman", "Strong", 1943, 34.31));
        heroes.add(new Superhero("Bruce Wayne", "Batman", "Agile", 1923, 65.21));
    }

    private ArrayList<Superhero> heroes = new ArrayList<>();

    public void addSuperheros(String name, String alias, String power, int year, double strength) {
        heroes.add(new Superhero(name, alias, power, year, strength));
    }

    public void addSuperhero(Superhero superhero) {
        heroes.add(superhero);
    }

    public void replaceSuperhero(String name, Superhero superhero) {
        int nr = heroes.indexOf(searchByAlias(name).get(0));
        heroes.set(nr, superhero);
    }
    public void deleteSuperhero(Superhero superhero) {
        heroes.remove(superhero);
    }

    public ArrayList<Superhero> getHeros() {
        return heroes;
    }

    public ArrayList<Superhero> searchByAlias(String alias) {
        ArrayList<Superhero> heroList = new ArrayList<>();

        for (Superhero superhero : heroes) {
            if (superhero.getAlias().toLowerCase().contains(alias.toLowerCase())) {
                heroList.add(superhero);
            }
        }
        return heroList;
    }
}