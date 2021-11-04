package com.c3spring.ejercicio.ejerciciosTarde.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PlatoInDTO {

    private String nombre;
    private List<IngredienteDTO> ingredientes;

}
