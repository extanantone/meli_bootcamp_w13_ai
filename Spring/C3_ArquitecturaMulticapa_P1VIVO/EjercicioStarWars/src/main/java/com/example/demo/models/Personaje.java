package com.example.demo.models;
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

    private String name;
    private int height;
    private int mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String gender;
    private String homeWorld;
    private String species;
    private String birthYear;


}