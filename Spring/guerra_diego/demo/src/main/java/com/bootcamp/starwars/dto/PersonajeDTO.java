package com.bootcamp.starwars.dto;

import com.bootcamp.starwars.model.Personaje;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonajeDTO {

    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;

    public PersonajeDTO(Personaje p) {
        this.name = p.getName();
        this.height = p.getHeight();
        this.mass = p.getMass();
        this.gender = p.getGender();
        this.homeworld = p.getHomeworld();
        this.species = p.getSpecies();
    }
}
