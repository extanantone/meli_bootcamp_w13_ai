package com.example.deportes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Deporte {
    public String nombre;
    public Integer nivel;

    public Deporte(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
}
