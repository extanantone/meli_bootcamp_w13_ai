package com.detectarDeportistas.ejercicioDeportistas.model;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public class Deporte {
    private String nombre;
    private String nivel;

    public Deporte(String nombre,String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
}
