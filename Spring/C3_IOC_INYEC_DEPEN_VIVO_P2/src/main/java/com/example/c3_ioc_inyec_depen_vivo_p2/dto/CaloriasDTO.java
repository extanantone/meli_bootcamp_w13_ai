package com.example.c3_ioc_inyec_depen_vivo_p2.dto;

import com.example.c3_ioc_inyec_depen_vivo_p2.model.Ingrediente;
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
public class CaloriasDTO
{
    private int totalCalorias;
    private Map<String, Integer> ingredientesCals;
    private Ingrediente ingredienteMaxCal;
}
