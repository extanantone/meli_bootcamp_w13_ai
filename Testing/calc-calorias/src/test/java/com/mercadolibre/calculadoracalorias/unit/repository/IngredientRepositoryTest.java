package com.mercadolibre.calculadoracalorias.unit.repository;

import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;
import com.mercadolibre.calculadoracalorias.repositories.IngredientRepository;
import com.mercadolibre.calculadoracalorias.repositories.IngredientRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class IngredientRepositoryTest {


    IngredientRepository ingredientRepository = new IngredientRepositoryImpl();

    @Test
    @DisplayName("With valid ingredient name then found ingred.")
    void withIngredientNameValidThenFoundIngredient() {
        //Arrange
        String ingredientName = "Aceitunas negras";
        IngredientDTO expected = new IngredientDTO(ingredientName, 349);
        //Act
        Optional<IngredientDTO> current = ingredientRepository.findIngredientByName(ingredientName);

        //Assert
        Assertions.assertEquals(expected, current.get());
    }
}
