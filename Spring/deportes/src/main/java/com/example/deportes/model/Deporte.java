package com.example.deportes.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Deporte  {
    private String nombre;
    private String nivel;
    public Deporte(){}
    public Deporte(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

}
