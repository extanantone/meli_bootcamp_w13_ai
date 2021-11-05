package com.C3P2VIVO.CalculadoraCalorias.repository;

import com.C3P2VIVO.CalculadoraCalorias.dto.IngredienteDTO;

public interface IIngredienteRepository {
    IngredienteDTO findIngredientByName(String name);
}
