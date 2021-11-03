package com.example.deportistas.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
public class Deporte{

    private Long id;

    private String nombre;

    private Integer nivel;

    public Deporte(Long id, String nombre, Integer nivel) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
    }
}
