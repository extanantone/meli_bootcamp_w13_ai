package com.bootcamp.deportistas.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Deporte {
    private String nombre;
    private String nivel; //ALEVIN, CADETE, JUVENIL, PROFESIONAL, ESTRELLA, LEYENDA

    @Override
    public String toString() {
        return "[" + nombre + ", " + nivel + "]";
    }
}

