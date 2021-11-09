package com.bootcamp.C3P1EJ1.dto;

import com.bootcamp.C3P1EJ1.model.Personaje;
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
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) //se lo pone en el dto también para que devuelva en snakecase
public class PersonajeDTO {
    private String name;
    private Integer height;
    private Integer mass;
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
