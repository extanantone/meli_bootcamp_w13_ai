package com.restaurant.unit;

import com.restaurant.controller.FoodController;
import com.restaurant.dto.PlateDto;
import com.restaurant.dto.ResultPlateDto;
import com.restaurant.service.IFoodService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FoodControllerTest {

    @InjectMocks
    private FoodController controller;

    @Mock
    private IFoodService service;

    @Test
    public void shouldBeSendFoodResult(){
        PlateDto dto = new PlateDto("tomatoes", List.of());
        ResultPlateDto rdto = new ResultPlateDto(0,null,List.of());
        Mockito.when(service.getIngredientDtoForPlate(dto)).thenReturn(rdto);
        ResultPlateDto rf = controller.getResultPlateDto(dto);
        assertEquals(rdto,rf);
    }


}
