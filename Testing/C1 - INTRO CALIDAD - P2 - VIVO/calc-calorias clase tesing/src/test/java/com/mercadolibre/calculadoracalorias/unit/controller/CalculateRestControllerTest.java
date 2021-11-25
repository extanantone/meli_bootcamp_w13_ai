package com.mercadolibre.calculadoracalorias.unit.controller;

import com.mercadolibre.calculadoracalorias.controller.CalculateRestController;
import com.mercadolibre.calculadoracalorias.dto.DishDTO;
import com.mercadolibre.calculadoracalorias.dto.DishResponseDTO;
import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;
import com.mercadolibre.calculadoracalorias.exception.IngredientNotFoundException;
import com.mercadolibre.calculadoracalorias.service.DishService;
import com.mercadolibre.calculadoracalorias.unit.service.DishServiceTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {
    @Mock
    DishService dishService;

    @InjectMocks
    CalculateRestController calculateRestController;

    @Test
    void DishWithoutIngredientThenCalories0(){
        // Arrange
        String dishName = "Plato 1";
        List<IngredientDTO> ingredients = new ArrayList<>();
        DishDTO dish = new DishDTO();
        dish.setIngredients(ingredients);
        dish.setName(dishName);

        DishResponseDTO dishResponseDTO = new DishResponseDTO(dish);
        dishResponseDTO.setCalories(0);

        // Act
        DishResponseDTO current = dishService.calculateCalories(dish);

        // Assert
        Assertions.assertNull(current);
        //Assertions.assertThrows(IngredientNotFoundException.class, () -> dishService.calculateCalories(dish));

    }
}
