package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.dto.IngredientDTO;

public interface IngredientRepo {
    IngredientDTO findIngredientByName(String name);
}
