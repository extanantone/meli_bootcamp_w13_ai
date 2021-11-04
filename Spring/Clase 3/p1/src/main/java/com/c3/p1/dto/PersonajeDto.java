package com.c3.p1.dto;

import com.c3.p1.model.Personaje;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class PersonajeDto {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;

    public PersonajeDto(Personaje personaje) {
        this.name = personaje.getName();
        this.height = personaje.getHeight();
        this.mass = personaje.getMass();
        this.gender = personaje.getGender();
        this.homeworld = personaje.getHomeworld();
        this.species = personaje.getSpecies();
    }
}
