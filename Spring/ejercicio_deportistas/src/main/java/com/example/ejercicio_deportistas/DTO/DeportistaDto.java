package com.example.ejercicio_deportistas.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor

public class DeportistaDto implements Serializable {
    String nombre;
    String apellido;
    String nombreDeporte;
}