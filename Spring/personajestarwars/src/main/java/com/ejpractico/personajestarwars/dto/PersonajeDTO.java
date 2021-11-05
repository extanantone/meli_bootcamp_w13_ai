package com.ejpractico.personajestarwars.dto;

import com.ejpractico.personajestarwars.model.Personaje;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PersonajeDTO {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;

    public PersonajeDTO(Personaje personaje) {
        this.name = personaje.getName();
        this.height = personaje.getHeight();
        this.mass = personaje.getMass();
        this.gender = personaje.getGender();
        this.homeworld = personaje.getHomeworld();
        this.species = personaje.getSpecies();
    }

}
