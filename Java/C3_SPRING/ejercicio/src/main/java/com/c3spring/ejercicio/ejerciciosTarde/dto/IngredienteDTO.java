package com.c3spring.ejercicio.ejerciciosTarde.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class IngredienteDTO {

    private int peso;
    private String nombre;
    private Double calorias;

}
