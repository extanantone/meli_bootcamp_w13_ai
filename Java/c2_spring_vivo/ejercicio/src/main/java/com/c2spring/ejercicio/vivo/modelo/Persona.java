package com.c2spring.ejercicio.vivo.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Persona {
    int edad;
    String nombre;
    String apellido;
    Deporte deporte;
}
