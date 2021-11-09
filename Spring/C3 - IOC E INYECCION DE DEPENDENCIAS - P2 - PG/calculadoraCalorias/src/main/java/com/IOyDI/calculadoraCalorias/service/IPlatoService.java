package com.IOyDI.calculadoraCalorias.service;

import com.IOyDI.calculadoraCalorias.dto.IngredienteDTO;
import com.IOyDI.calculadoraCalorias.dto.PlatoDTO;

import java.util.List;

public interface IPlatoService {
    Double getCalorias(PlatoDTO plato);
    List<IngredienteDTO> getIngredientes(PlatoDTO plato);
    IngredienteDTO getIngredienteMasCalorias(PlatoDTO plato);
}
