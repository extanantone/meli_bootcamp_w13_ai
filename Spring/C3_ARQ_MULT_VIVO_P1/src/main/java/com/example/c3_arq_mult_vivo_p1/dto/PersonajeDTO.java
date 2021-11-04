package com.example.c3_arq_mult_vivo_p1.dto;

import com.example.c3_arq_mult_vivo_p1.model.Personaje;
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
public class PersonajeDTO
{
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeWorld;
    private String species;

    public PersonajeDTO(Personaje personaje)
    {
        this.name = personaje.getName();
        this.height = personaje.getHeight();
        this.mass = personaje.getMass();
        this.gender = personaje.getGender();
        this.homeWorld = personaje.getHomeworld();
        this.species = personaje.getSpecies();
    }
}
