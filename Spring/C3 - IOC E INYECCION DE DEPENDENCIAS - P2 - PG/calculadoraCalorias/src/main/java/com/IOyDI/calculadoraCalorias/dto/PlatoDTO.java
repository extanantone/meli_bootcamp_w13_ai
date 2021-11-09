package com.IOyDI.calculadoraCalorias.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PlatoDTO {
    private String nombre;
    private List<IngredienteDTO> ingredientes;
}
