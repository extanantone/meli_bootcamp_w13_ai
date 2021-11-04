package com.bootcamp.calculadora_de_calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class IngredienteDTO {

    private String nombre;
    private Double peso;

}
