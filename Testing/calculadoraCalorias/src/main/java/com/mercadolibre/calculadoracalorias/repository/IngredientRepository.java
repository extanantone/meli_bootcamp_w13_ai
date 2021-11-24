package com.mercadolibre.calculadoracalorias.repository;

import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;

import java.util.Optional;

public interface IngredientRepository {
  Optional<IngredientDTO> findIngredientByName(String name);
}
