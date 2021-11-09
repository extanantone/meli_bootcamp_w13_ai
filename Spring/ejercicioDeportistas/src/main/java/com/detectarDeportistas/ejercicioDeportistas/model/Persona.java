package com.detectarDeportistas.ejercicioDeportistas.model;

import com.detectarDeportistas.ejercicioDeportistas.service.PersonaService;
import lombok.Getter;
@Getter
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;

    public Persona(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }

}
