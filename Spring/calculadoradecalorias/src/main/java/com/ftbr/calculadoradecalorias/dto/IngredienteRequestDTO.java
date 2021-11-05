package com.ftbr.calculadoradecalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
public class IngredienteRequestDTO {
    String nombre;
    int gramos;

    @Override
    public String toString() {
        return "IngredienteDTO{" +
                "nombre='" + nombre + '\'' +
                ", gramos=" + gramos +
                '}';
    }
}
