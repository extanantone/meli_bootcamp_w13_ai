package com.IOyDI.calculadoraCalorias.service;

import com.IOyDI.calculadoraCalorias.dto.IngredienteDTO;

import java.util.List;

public interface IIngredienteService {
    List<IngredienteDTO> getIngredientes();
    IngredienteDTO getIngredienteByName(String nombre);
}
