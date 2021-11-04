package com.example.demo.controller;

import com.example.demo.dto.DishDTO;
import com.example.demo.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class FoodController {
    @Autowired
    private IFoodRepository foodRepository;
    //@GetMapping("/Dish")
    @PostMapping("/dishes")
    public ResponseEntity<?> caloriesOfDish(@RequestBody DishDTO dish){
        return new ResponseEntity(foodRepository.foodCalories(dish.getFoodAndHeigh()), HttpStatus.OK);
    }
}
