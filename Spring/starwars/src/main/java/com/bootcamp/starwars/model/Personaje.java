package com.bootcamp.starwars.model;

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
public class Personaje {
    String name;
    int height;
    int mass;
    String hairColor;
    String skinColor;
    String eyeColor;
    String birthYear;
    String gender;
    String homeworld;
    String species;
}
