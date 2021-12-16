package com.mercadolibre.calculadoracalorias.unit.controller;

import com.mercadolibre.calculadoracalorias.controller.CalculateRestController;
import com.mercadolibre.calculadoracalorias.dto.DishDTO;
import com.mercadolibre.calculadoracalorias.dto.DishResponseDTO;
import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;
import com.mercadolibre.calculadoracalorias.service.DishServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {

    @Mock
    DishServiceImpl service;

    @InjectMocks
    CalculateRestController controller;

    @Test
    void dishWithoutIngredientsThenCalories0(){
        // Arrange
        String dishName = "aksjhd";
        List<IngredientDTO> ingredients = new ArrayList<>();
        DishDTO dish = new DishDTO();
        dish.setIngredients(ingredients);
        dish.setName(dishName);

        Integer expect = 0;

        // Mocks
        DishResponseDTO dishMock = new DishResponseDTO();
        dishMock.setCalories(0);
        Mockito.when(service.calculateCalories(dish)).thenReturn(dishMock);

        // Act
        DishResponseDTO current = controller.calculate(dish);

        // Assert
        Assertions.assertEquals(expect, current.getCalories());
    }

}
