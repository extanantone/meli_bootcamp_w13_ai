package com.ejercicio.demo.dto;

import com.ejercicio.demo.models.Character;
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
public class CharacterDTO {

    private String name;
    private int heigth;
    private int mass;
    private String gender;
    private String homeWorld;
    private String species;

    public CharacterDTO(Character character){

        this.name = character.getName();
        this.heigth = character.getHeight();
        this.mass = character.getMass();
        this.gender = character.getGender();
        this.homeWorld = character.getHomeworld();
        this.species = character.getSpecies();

    }

}
