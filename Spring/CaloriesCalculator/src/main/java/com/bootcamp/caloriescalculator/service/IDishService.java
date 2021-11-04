package com.bootcamp.caloriescalculator.service;

import com.bootcamp.caloriescalculator.dto.DishReqDTO;
import com.bootcamp.caloriescalculator.dto.DishResDTO;

public interface IDishService {

    public DishResDTO getDishWithCalories(DishReqDTO dishReqDTO);
}
