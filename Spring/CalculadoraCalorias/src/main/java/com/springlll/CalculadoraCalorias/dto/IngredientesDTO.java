package com.springlll.CalculadoraCalorias.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientesDTO {
    private String nombre;
    private int calorias;
    private int peso;

    public IngredientesDTO(String nombre, int peso) {
        this.nombre = nombre;
        this.peso = peso;
    }
}
