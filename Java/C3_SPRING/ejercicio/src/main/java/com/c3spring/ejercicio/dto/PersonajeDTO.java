package com.c3spring.ejercicio.dto;

import com.c3spring.ejercicio.model.Personaje;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonajeDTO {

    private String name;
    private String gender;
    private String homeworld;
    private String species;
    private int height;
    private int mass;

    public PersonajeDTO(Personaje personaje) {
        this.name = personaje.getName();
        this.height = personaje.getHeight();
        this.mass = personaje.getMass();
        this.gender = personaje.getGender();
        this.homeworld = personaje.getHomeworld();
        this.species = personaje.getSpecies();
    }
}
