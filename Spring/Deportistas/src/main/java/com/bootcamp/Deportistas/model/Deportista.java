package com.bootcamp.Deportistas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Deportista {
    private String nombre;
    private String apellido;
    private Integer edad;
}
