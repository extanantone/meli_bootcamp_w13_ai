package com.C3P2VIVO.CalculadoraCalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlatoDTO {
    private String name;
    private List<IngredienteDTO> ingredientes;

}
