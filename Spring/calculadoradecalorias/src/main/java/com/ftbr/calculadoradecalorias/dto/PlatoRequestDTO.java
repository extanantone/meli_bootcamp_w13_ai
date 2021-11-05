package com.ftbr.calculadoradecalorias.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class PlatoRequestDTO {
    private String nombre;
    private List<IngredienteRequestDTO> ingredientes;

    public PlatoRequestDTO(String nombre, List<IngredienteRequestDTO> ingredientes){
        this.nombre = nombre;
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "PlatoRequestDTO{" +
                "nombre='" + nombre + '\'' +
                ", ingredientes=" + ingredientes +
                '}';
    }
}
