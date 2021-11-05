package com.ftbr.calculadoradecalorias.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PlatoDTO {
    private String nombre;
    private int caloriasTotales;
    private List ingredientes;
    private String ingredienteConMaxCalorias;
}
