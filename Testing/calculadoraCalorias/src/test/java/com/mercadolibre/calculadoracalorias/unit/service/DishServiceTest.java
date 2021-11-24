package com.mercadolibre.calculadoracalorias.unit.service;

import com.mercadolibre.calculadoracalorias.dto.DishDTO;
import com.mercadolibre.calculadoracalorias.dto.DishResponseDTO;
import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;
import com.mercadolibre.calculadoracalorias.repository.IngredientRepository;
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
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
public class DishServiceTest {
    @Mock
    IngredientRepository repository;

    @InjectMocks
    DishServiceImpl service;

    @Test
    public void shouldCalculateCalories() {

        // Arrange

        List<IngredientDTO> ingredientsList = new ArrayList<>();

        IngredientDTO ingredient1 = new IngredientDTO("Mayonesa", 718);
        IngredientDTO ingredient2 = new IngredientDTO("Atun en lata con agua", 127);

        ingredient1.setWeight(100);
        ingredient2.setWeight(100);

        ingredientsList.add(ingredient1);
        ingredientsList.add(ingredient2);

        DishDTO dish = new DishDTO();
        dish.setName("Atún con mayonesa");
        dish.setIngredients(ingredientsList);

        DishResponseDTO expected = new DishResponseDTO(dish);
        expected.setCaloric(ingredient1);
        expected.setCalories(ingredient1.getCalories() + ingredient2.getCalories());

        // Act


        IngredientDTO mockIngredient1 = new IngredientDTO("Mayonesa", 718);
        IngredientDTO mockIngredient2 = new IngredientDTO("Atun en lata con agua", 127);

        Mockito.when(repository.findIngredientByName(ingredient1.getName())).thenReturn(Optional.of(mockIngredient1));
        Mockito.when(repository.findIngredientByName(ingredient2.getName())).thenReturn(Optional.of(mockIngredient2));

        DishResponseDTO result = service.calculateCalories(dish);

        // Assert

        Mockito.verify(repository, Mockito.atLeastOnce()).findIngredientByName(Mockito.anyString());

        Assertions.assertAll(
                () -> Assertions.assertEquals(expected.getName(), result.getName()),
                () -> Assertions.assertEquals(expected.getIngredients(), result.getIngredients()),
                () -> Assertions.assertEquals(expected.getCalories(), result.getCalories()),
                () -> Assertions.assertEquals(expected.getCaloric(), result.getCaloric())
        );

    }

    @Test
    public void shouldReturn0ForDishWithNoIngredients() {

        // Arrange

        List<IngredientDTO> ingredientsList = new ArrayList<>();

        DishDTO dish = new DishDTO();
        dish.setName("Atún con mayonesa");
        dish.setIngredients(ingredientsList);

        DishResponseDTO expected = new DishResponseDTO(dish);
        expected.setCalories(0);

        // Act

        DishResponseDTO result = service.calculateCalories(dish);

        // Assert

        Assertions.assertAll(
                () -> Assertions.assertEquals(expected.getName(), result.getName()),
                () -> Assertions.assertEquals(expected.getIngredients(), result.getIngredients()),
                () -> Assertions.assertEquals(expected.getCalories(), result.getCalories()),
                () -> Assertions.assertEquals(expected.getCaloric(), result.getCaloric())
        );

    }

//    private boolean isResponseCorrect(List<DishResponseDTO> expected, List<DishResponseDTO> result) {
//        boolean res = true;
//        for (DishResponseDTO d : expected) {
//            res = res && result.stream().anyMatch(dish ->
//                    dish.getName().equals(d.getName())
////                            && dish.getIngredients().equals(d.getIngredients())
////                            && dish.getCaloric().equals(d.getCaloric())
//                            && dish.getCalories().equals(d.getCalories()));
//        }
//
//        return res;
//    }

//    @Test
//    public void shouldCalculateCaloriesForMultipleDishes() {
//
//        // Arrange
//
//        List<IngredientDTO> ingredientsList1 = new ArrayList<>();
//        List<IngredientDTO> ingredientsList2 = new ArrayList<>();
//
//        IngredientDTO ingredient1 = new IngredientDTO("Mayonesa", 718);
//        IngredientDTO ingredient2 = new IngredientDTO("Atun en lata con agua", 127);
//        IngredientDTO ingredient3 = new IngredientDTO("Arroz blanco", 354);
//        IngredientDTO ingredient4 = new IngredientDTO("Pollo", 134);
//
//        ingredient1.setWeight(100);
//        ingredient2.setWeight(100);
//        ingredient3.setWeight(100);
//        ingredient4.setWeight(100);
//
//        ingredientsList1.add(ingredient1);
//        ingredientsList1.add(ingredient2);
//        ingredientsList2.add(ingredient3);
//        ingredientsList2.add(ingredient4);
//
//        DishDTO dish1 = new DishDTO();
//        dish1.setName("Atún con mayonesa");
//        dish1.setIngredients(ingredientsList1);
//
//        DishDTO dish2 = new DishDTO();
//        dish2.setName("Arroz con pollo");
//        dish2.setIngredients(ingredientsList2);
//
//        List<DishDTO> dishList = new ArrayList<>();
//        List<DishResponseDTO> expected = new ArrayList<>();
//
//        DishResponseDTO expectedDishResponse1 = new DishResponseDTO(dish1);
//        DishResponseDTO expectedDishResponse2 = new DishResponseDTO(dish2);
//
//        expectedDishResponse1.setCaloric(ingredient1);
//        expectedDishResponse1.setCalories(ingredient1.getCalories() + ingredient2.getCalories());
//
//        expectedDishResponse2.setCaloric(ingredient3);
//        expectedDishResponse2.setCalories(ingredient3.getCalories() + ingredient4.getCalories());
//
//        expected.add(expectedDishResponse1);
//        expected.add(expectedDishResponse2);
//
//        // Act
//
//        IngredientDTO mockIngredient1 = new IngredientDTO("Mayonesa", 718);
//        IngredientDTO mockIngredient2 = new IngredientDTO("Atun en lata con agua", 127);
//        IngredientDTO mockIngredient3 = new IngredientDTO("Arroz blanco", 354);
//        IngredientDTO mockIngredient4 = new IngredientDTO("Pollo", 134);
//
//        Mockito.when(repository.findIngredientByName(ingredient1.getName())).thenReturn(Optional.of(mockIngredient1));
//        Mockito.when(repository.findIngredientByName(ingredient2.getName())).thenReturn(Optional.of(mockIngredient2));
//        Mockito.when(repository.findIngredientByName(ingredient3.getName())).thenReturn(Optional.of(mockIngredient3));
//        Mockito.when(repository.findIngredientByName(ingredient4.getName())).thenReturn(Optional.of(mockIngredient4));
//
//        List<DishResponseDTO> result = service.calculateAllCalories(dishList);
//
//        // Assert
//
////        Mockito.verify(repository, Mockito.atLeast(4)).findIngredientByName(Mockito.anyString());
//
//        Assertions.assertTrue(isResponseCorrect(expected, result));
//
//    }

}
