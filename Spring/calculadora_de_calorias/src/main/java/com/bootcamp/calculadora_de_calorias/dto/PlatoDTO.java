package com.bootcamp.calculadora_de_calorias.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PlatoDTO {

    private String nombre;
    private List<IngredienteDTO> ingredientes;

}
