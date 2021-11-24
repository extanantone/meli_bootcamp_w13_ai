package com.mercadolibre.calculadoracalorias.unit.repository;

import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;
import com.mercadolibre.calculadoracalorias.repository.IngredientRepository;
import com.mercadolibre.calculadoracalorias.repository.IngredientRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class IngredientRepositoryTest {
    IngredientRepository repository = new IngredientRepositoryImpl();

    @Test
    public void shouldFindIngredientByName() {
        // Arrange

        String ingredientName = "Ajos";
        IngredientDTO expected = new IngredientDTO("Ajos", 169);

        // Act

        Optional<IngredientDTO> result = repository.findIngredientByName(ingredientName);

        // Assert

        Assertions.assertEquals(expected, result.get());
    }

    @Test
    public void shouldNotFindIngredientByName() {
        // Arrange

        String ingredientName = "Non existent ingredient";

        // Act

        Optional<IngredientDTO> result = repository.findIngredientByName(ingredientName);

        // Assert

        Assertions.assertTrue(result.isEmpty());
    }
}
