package com.example.bootcamp.StarWarsApi.dto;

import com.example.bootcamp.StarWarsApi.model.Personaje;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
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
