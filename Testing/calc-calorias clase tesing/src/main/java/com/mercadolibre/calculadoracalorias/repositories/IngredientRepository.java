package com.mercadolibre.calculadoracalorias.repositories;

import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;

import java.util.Optional;

public interface IngredientRepository {
  Optional<IngredientDTO> findIngredientByName(String name);
}
