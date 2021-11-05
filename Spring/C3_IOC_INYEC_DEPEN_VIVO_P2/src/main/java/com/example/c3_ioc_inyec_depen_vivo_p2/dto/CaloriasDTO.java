package com.example.c3_ioc_inyec_depen_vivo_p2.dto;

import com.example.c3_ioc_inyec_depen_vivo_p2.model.Ingrediente;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CaloriasDTO
{
    private String platoNombre;
    private long totalCalorias;
    private Map<String, Integer> ingredientesCals;
    private String ingredienteMaxCal;
}
