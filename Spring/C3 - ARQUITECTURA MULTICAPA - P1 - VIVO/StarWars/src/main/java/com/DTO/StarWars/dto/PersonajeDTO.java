package com.DTO.StarWars.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonajeDTO {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;
}
