package com.example.ejercicio_deportistas.Modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Persona {
    String nombre;
    String apellido;
    Integer edad;
    Deporte deporte;
}