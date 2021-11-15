package com.springlll.CalculadoraCalorias.service;

import com.springlll.CalculadoraCalorias.dto.IngredientesDTO;
import com.springlll.CalculadoraCalorias.dto.PlatoDTO;
import com.springlll.CalculadoraCalorias.model.Ingredientes;

import java.util.List;

public interface IIngredientesService {
    List<PlatoDTO> obtenerPlato(PlatoDTO plato);
}
