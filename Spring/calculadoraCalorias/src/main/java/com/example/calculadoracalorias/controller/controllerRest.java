package com.example.calculadoracalorias.controller;

import com.example.calculadoracalorias.dto.DishDTO;
import com.example.calculadoracalorias.dto.DishResponseDTO;
import com.example.calculadoracalorias.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controllerRest {
    final DishService calories;

    public controllerRest(DishService calories) {
        this.calories = calories;
    }

    @PostMapping("/dish/calories")
    public DishDTO getCalorias(@RequestBody DishDTO x){
       return calories.calculateCalories(x);
    }
    /*
    @PostMapping("/dish/all")
    public DishResponseDTO getAllCalories(@RequestBody DishResponseDTO all){
        return
    }*/
}
