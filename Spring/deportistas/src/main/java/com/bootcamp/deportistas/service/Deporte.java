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
    private Nivel nivel;

    @Override
    public String toString() {
        return "[" + nombre + ", " + nivel + "]";
    }
}

