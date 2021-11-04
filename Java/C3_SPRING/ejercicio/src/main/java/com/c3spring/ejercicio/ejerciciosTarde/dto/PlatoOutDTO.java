package com.c3spring.ejercicio.ejerciciosTarde.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlatoOutDTO {

    private String nombre;
    private Double totalCalorias;
    private String mayorCalorico;
    private List<IngredienteDTO> listaIngredientes;

}
