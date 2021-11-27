package com.mercadolibre.calculadoracalorias.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {
  private List<IngredientDTO> ingredients;

  public IngredientRepositoryImpl() {
    ingredients = loadDataBase();
  }

  @Override
  public Optional<IngredientDTO> findIngredientByName(String name) {
    return ingredients.stream().filter(ingredientDTO -> ingredientDTO.getName().equals(name)).findFirst();
  }

  private List<IngredientDTO> loadDataBase() {
    List<IngredientDTO> ingredients = null;

    File file = null;
    ObjectMapper objectMapper = new ObjectMapper();
    TypeReference<List<IngredientDTO>> typeRef = new TypeReference<>() {};

    try {
      file = ResourceUtils.getFile("classpath:food.json");
      ingredients = objectMapper.readValue(file, typeRef);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return ingredients;
  }
}
