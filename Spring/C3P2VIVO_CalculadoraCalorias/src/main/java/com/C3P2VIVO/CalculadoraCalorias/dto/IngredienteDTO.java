package com.C3P2VIVO.CalculadoraCalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IngredienteDTO {
    private String name;
    private Integer calories;
    private Integer weight;

}
