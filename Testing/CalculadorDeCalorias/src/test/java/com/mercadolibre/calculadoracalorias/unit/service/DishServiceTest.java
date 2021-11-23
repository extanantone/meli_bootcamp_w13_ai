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
    void DishWithIngredientThenCalories523(){
        // Arrange
        String dishName = "dishName";
        List<IngredientDTO> ingredients = new ArrayList<>();
        IngredientDTO ingredient = new IngredientDTO("ingredientName", 349);
        ingredient.setWeight(150);
        ingredients.add(ingredient);
        DishDTO dish = new DishDTO();
        dish.setIngredients(ingredients);
        dish.setName(dishName);

        Integer expect = 523;

        // Mocks
        IngredientDTO ingredientMock = new IngredientDTO("ingredientName", 349);
        Mockito.when(repo.findIngredientByName(ingredient.getName())).thenReturn(Optional.of(ingredientMock));

        // Act
        DishResponseDTO current = service.calculateCalories(dish);

        // Assert & verificar uso de mocks
        Mockito.verify(repo, Mockito.atLeastOnce()).findIngredientByName(Mockito.anyString());
        Assertions.assertEquals(expect, current.getCalories());
    }

    @Test
    void DishesWithIngredientsThenCalories1000(){
        // Arrange
        String dishName1 = "dishName1";
        List<IngredientDTO> ingredients1 = new ArrayList<>();
        IngredientDTO ingredient1 = new IngredientDTO("ingredient1", 500);
        ingredient1.setWeight(200);
        ingredients1.add(ingredient1);
        DishDTO dish1 = new DishDTO();
        dish1.setIngredients(ingredients1);
        dish1.setName(dishName1);

        String dishName2 = "dishName2";
        List<IngredientDTO> ingredients2 = new ArrayList<>();
        IngredientDTO ingredient2 = new IngredientDTO("ingredient2", 600);
        ingredient2.setWeight(50);
        ingredients2.add(ingredient2);
        DishDTO dish2 = new DishDTO();
        dish2.setIngredients(ingredients2);
        dish2.setName(dishName2);

        Integer expect1 = 1000;
        Integer expect2 = 300;

        List<DishDTO> dishes = new ArrayList();
        dishes.add(dish1);
        dishes.add(dish2);

        // Mocks
        IngredientDTO ingredientMock1 = new IngredientDTO("ingredientMock1", 500);
        IngredientDTO ingredientMock2 = new IngredientDTO("ingredientMock2", 600);
        Mockito.when(repo.findIngredientByName(ingredient1.getName())).thenReturn(Optional.of(ingredientMock1));
        Mockito.when(repo.findIngredientByName(ingredient2.getName())).thenReturn(Optional.of(ingredientMock2));

        // Act
        List<DishResponseDTO> current = service.calculateAllCalories(dishes);

        //Mockito.verify(service, Mockito.atLeast(2)).calculateCalories(Mockito.any());

        Assertions.assertAll(
                () -> Assertions.assertEquals(expect1, current.get(0).getCalories()),
                () -> Assertions.assertEquals(expect2, current.get(1).getCalories())
        );
    }

    @Test
    void DishWithoutIngredientThenCaloriesError(){
        // Arrange
        String dishName = "aksjhd";
        List<IngredientDTO> ingredients = new ArrayList<>();
        IngredientDTO ingredient = new IngredientDTO("NOT FOUND", 349);
        ingredient.setWeight(150);
        ingredients.add(ingredient);
        DishDTO dish = new DishDTO();
        dish.setIngredients(ingredients);
        dish.setName(dishName);

        // Mocks
        Mockito.when(repo.findIngredientByName(ingredient.getName())).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(IngredientNotFoundException.class, () -> service.calculateCalories(dish));
    }
}
