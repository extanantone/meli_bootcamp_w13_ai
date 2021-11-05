package com.example.calculadora_calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class IngredienteDTO {
    String nombre;
    Integer calorias;
    Double peso;
}
