package com.c3spring.ejercicio.manana.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Personaje {

    private String name;
    private String birthYear;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String gender;
    private String homeworld;
    private String species;
    private int height;
    private int mass;

}
