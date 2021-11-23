package com.restaurant.unit;

import com.restaurant.dto.IngredientDto;
import com.restaurant.dto.PlateDto;
import com.restaurant.dto.ResultPlateDto;
import com.restaurant.model.Food;
import com.restaurant.repository.IFoodRepository;
import com.restaurant.service.FoodService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class FoodServiceTest {

    @InjectMocks
    private FoodService service;

    @Mock
    private IFoodRepository repository;


    @Test
    public void shouldntCalcCaloriesByUnexistFood(){
        String name ="unknow";
        PlateDto dto = new PlateDto("pasta", List.of(new IngredientDto(name,1)));
        Mockito.when(repository.getFootByName(name)).thenReturn(new Food());
        ResultPlateDto result = service.getIngredientDtoForPlate(dto);
        assertEquals(result.getFullCalories(),0);
        assertEquals(result.getIngredients().get(0).getCalories(),0);
    }

    @Test
    public void shouldFindAllCaloriesForExistFood(){
        //
        String ingredient = "Pasta";
        String ingredient2 = "Tomate";
        PlateDto dto = new PlateDto("lasagna",List.of(new IngredientDto(ingredient,100),new IngredientDto(ingredient2,100)));
        Mockito.when(repository.getFootByName(ingredient)).thenReturn(new Food(ingredient,2));
        Mockito.when(repository.getFootByName(ingredient2)).thenReturn(new Food(ingredient2,3));
        //
        ResultPlateDto result = service.getIngredientDtoForPlate(dto);
        //
        assertEquals(result.getFullCalories(),5);
        assertEquals(result.getIngredients().get(0).getCalories(),2);
        assertEquals(result.getIngredients().get(1).getCalories(),3);

    }

    @Test
    public void theIngredientsWouldHaveSameCalories(){
        String ingredient1 = "Pasta";
        String ingredient2 = "Lechuga";
        PlateDto dto = new PlateDto("lasagna",List.of(new IngredientDto(ingredient1,1),new IngredientDto(ingredient2,2)));
        Mockito.when(repository.getFootByName(ingredient1)).thenReturn(new Food(ingredient1,100));
        Mockito.when(repository.getFootByName(ingredient2)).thenReturn(new Food(ingredient2,50));
        ResultPlateDto result = service.getIngredientDtoForPlate(dto);
        assertEquals(result.getIngredients().get(0).getCalories(),result.getIngredients().get(1).getCalories());
    }


    @Test
    void  pass(){
        assertEquals("","");
    }

}
