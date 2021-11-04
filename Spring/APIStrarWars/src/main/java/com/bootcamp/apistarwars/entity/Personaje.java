package com.bootcamp.apistarwars.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//Mapea las variables a SnakeCase dado que en el JSON estan asi
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Personaje {

    private String name;
    private Integer height;
    private Integer mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;

}
