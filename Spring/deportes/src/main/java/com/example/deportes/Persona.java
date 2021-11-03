package com.example.deportes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Persona {
    public String nombre;
    public String apellido;
    public int edad;

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
}
