package com.mercadolibre.calculadoracalorias.unit.service;

import com.mercadolibre.calculadoracalorias.dto.DishDTO;
import com.mercadolibre.calculadoracalorias.dto.DishResponseDTO;
import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;
import com.mercadolibre.calculadoracalorias.exception.IngredientNotFoundException;
import com.mercadolibre.calculadoracalorias.repositories.IngredientRepository;
import com.mercadolibre.calculadoracalorias.repositories.IngredientRepositoryImpl;
import com.mercadolibre.calculadoracalorias.service.DishService;
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
public class DishServiceTest {

    //mock
    @Mock
    IngredientRepository repo;

    //lo que quiero testear
    @InjectMocks
    DishServiceImpl service;

    @Test
    void DishWithoutIngredientThenCalories0(){
        // Arrange
        String dishName = "aksjhd";
        List<IngredientDTO> ingredients = new ArrayList<>();
        DishDTO dish = new DishDTO();
        dish.setIngredients(ingredients);
        dish.setName(dishName);

        Integer expect = 0;

        // Act
        DishResponseDTO current = service.calculateCalories(dish);

        // Assert
        Assertions.assertEquals(expect, current.getCalories());
    }

    @Test
    void DishWithoutIngredientThenCalories523(){
        // Arrange
        String dishName = "aksjhd";
        List<IngredientDTO> ingredients = new ArrayList<>();
        IngredientDTO ingredient = new IngredientDTO("NOT FOUND", 349);
        ingredient.setWeight(150);
        ingredients.add(ingredient);
        DishDTO dish = new DishDTO();
        dish.setIngredients(ingredients);
        dish.setName(dishName);

        Integer expect = 523;

        // Mocks
        IngredientDTO ingredientMock = new IngredientDTO("NOT FOUND", 349);
        Mockito.when(repo.findIngredientByName(ingredient.getName())).thenReturn(Optional.of(ingredientMock));

        // Act
        DishResponseDTO current = service.calculateCalories(dish);

        // Assert & verificar uso de mocks
        Mockito.verify(repo, Mockito.atLeastOnce()).findIngredientByName(Mockito.anyString());
        //Mockito.verify(repo, Mockito.atLeast(3)).findIngredientByName(ingredient.getName());
        Assertions.assertEquals(expect, current.getCalories());
    }

    @Test
    void DishAllCalories(){
        // Arrange
        String dishName = "aksjhd";
        List<IngredientDTO> ingredients = new ArrayList<>();
        IngredientDTO ingredient = new IngredientDTO("NOT FOUND", 349);
        ingredient.setWeight(150);
        ingredients.add(ingredient);
        DishDTO dish = new DishDTO();
        dish.setIngredients(ingredients);
        dish.setName(dishName);
        List<DishDTO> dishes = new ArrayList<>();
        dishes.add(dish);
        dishes.add(dish);

        // Mocks
        IngredientDTO ingredientMock = new IngredientDTO("NOT FOUND", 349);
        Mockito.when(repo.findIngredientByName(ingredient.getName())).thenReturn(Optional.of(ingredientMock));

        // Act
        List<DishResponseDTO> result = service.calculateAllCalories(dishes);

        // Assert
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(result.get(0).getCalories(), 523);
        Assertions.assertEquals(result.get(1).getCalories(), 523);
    }

    @Test
    void DishAllCaloriesIngredientNotFound(){
        // Arrange
        String dishName = "aksjhd";
        List<IngredientDTO> ingredients = new ArrayList<>();
        IngredientDTO ingredient = new IngredientDTO("NOT FOUND", 349);
        ingredient.setWeight(150);
        ingredients.add(ingredient);
        DishDTO dish = new DishDTO();
        dish.setIngredients(ingredients);
        dish.setName(dishName);
        List<DishDTO> dishes = new ArrayList<>();
        dishes.add(dish);
        dishes.add(dish);

        // Act && Assert
        Assertions.assertThrows(IngredientNotFoundException.class, () -> service.calculateAllCalories(dishes));
    }
}
