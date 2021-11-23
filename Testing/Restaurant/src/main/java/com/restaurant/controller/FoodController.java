package com.restaurant.controller;

import com.restaurant.dto.PlateDto;
import com.restaurant.dto.ResultPlateDto;
import com.restaurant.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurante/calorias")
public class FoodController {

    @Autowired
    private IFoodService service;

    @PostMapping
    public ResultPlateDto getResultPlateDto(@RequestBody PlateDto plateDto){
        return service.getIngredientDtoForPlate(plateDto);
    }

}
