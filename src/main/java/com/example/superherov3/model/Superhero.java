package com.example.superherov3.model;

public class Superhero {
    private String name;
    private String alias;
    private String power;
    private int year;
    private double strength;

    public Superhero(String name, String alias, String power, int year, double strength) {
        this.name = name;
        this.alias = alias;
        this.power = power;
        this.year = year;
        this.strength = strength;
    }

    public String getAlias() {
        return alias;
    }

    public String toString() {
        return "> Real name: " + name
                + "\n> Alias: " + alias
                + "\n> Superpower: " + power
                + "\n> Year of publication: " + year
                + "\n> Strength: " + strength + "\n";
    }
}

