package com.C3P2VIVO.CalculadoraCalorias.service;

import com.C3P2VIVO.CalculadoraCalorias.dto.PlatoCalculadoDTO;
import com.C3P2VIVO.CalculadoraCalorias.dto.PlatoDTO;

import java.util.List;

public interface IPlatoService {
    PlatoCalculadoDTO calcularCalories(PlatoDTO platoDTO);

    List<PlatoCalculadoDTO> calcularCaloriesPlatos(List<PlatoDTO> platosDTO);
}
