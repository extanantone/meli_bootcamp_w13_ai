package com.bootcamp.calculadoraDeCalorias.controller;

import com.bootcamp.calculadoraDeCalorias.dto.DishDTO;
import com.bootcamp.calculadoraDeCalorias.service.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurant")
public class FoodController {
    @Autowired
    private IFoodRepository foodRepository;

    @PostMapping("/dishes")
    public ResponseEntity<?> caloriesOfDish(@RequestBody DishDTO dish) {
        return new ResponseEntity<>(foodRepository.foodCalories(dish.getFoodAndWeight()), HttpStatus.OK);
    }
}