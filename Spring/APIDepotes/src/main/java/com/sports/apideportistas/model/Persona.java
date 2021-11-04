package com.sports.apideportistas.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Persona {

    private String nombre;

    private String apellido;

    private Integer edad;

}
