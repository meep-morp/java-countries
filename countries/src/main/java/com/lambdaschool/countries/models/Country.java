package com.lambdaschool.countries.models;

import javax.persistence.*;

@Entity
@Table(name = "countries")

public class Country {

    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String cname;
    int population;
    int land_mass;
    int median_age;

    // Constructors

    public Country(String name, int population, int land_mass, int median_age) {
        this.cname = name;
        this.population = population;
        this.land_mass = land_mass;
        this.median_age = median_age;
    }

    public Country() {
    }

    // Getters and Setters

    public String getCname() {
        return cname;
    }

    public void setCname(String name) {
        this.cname = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getLand_mass() {
        return land_mass;
    }

    public void setLand_mass(int land_mass) {
        this.land_mass = land_mass;
    }

    public int getMedian_age() {
        return median_age;
    }

    public void setMedian_age(int median_age) {
        this.median_age = median_age;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + cname + '\'' +
                ", population=" + population +
                ", land_mass=" + land_mass +
                ", median_age=" + median_age +
                '}';
    }
}
