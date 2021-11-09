package com.IOyDI.calculadoraCalorias.dto;

import com.IOyDI.calculadoraCalorias.entity.Ingrediente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class IngredienteDTO {
    private String nombre;
    private int gramos;
    private double calorias;

    public IngredienteDTO (Ingrediente ingrediente){
        this.nombre = ingrediente.getName();
        this.calorias = ingrediente.getCalories();
    }

    public IngredienteDTO(String nombre, int gramos) {
        this.nombre = nombre;
        this.gramos = gramos;
    }
}
