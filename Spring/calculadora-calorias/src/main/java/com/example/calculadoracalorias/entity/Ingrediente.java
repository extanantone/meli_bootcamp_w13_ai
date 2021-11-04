package com.example.calculadoracalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Ingrediente {
    private String nombre;
    private int calorias;

    @Override
    public String toString() {
        return "{ " +
                "nombre= " + nombre +
                ", calorias=" + calorias +
                " }";
    }
}
