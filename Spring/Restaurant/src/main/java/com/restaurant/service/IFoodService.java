package com.restaurant.service;

import com.restaurant.dto.IngredientDto;
import com.restaurant.dto.PlateDto;
import com.restaurant.dto.ResultPlateDto;

public interface IFoodService {
    ResultPlateDto getIngredientDtoForPlate(PlateDto plate);
}
