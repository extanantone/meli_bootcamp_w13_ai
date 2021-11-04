package com.bootcamp.caloriescalculator.controller;

import com.bootcamp.caloriescalculator.dto.DishReqDTO;
import com.bootcamp.caloriescalculator.dto.DishResDTO;
import com.bootcamp.caloriescalculator.service.IDishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    IDishService dishService;

    public DishController(IDishService dishService) {
        this.dishService = dishService;
    }

    // Testing
    @GetMapping
    public String sayHI() {
        return "Hi";
    }

    @PostMapping("/calories")
    public ResponseEntity<DishResDTO> getDishWithCalories(@RequestBody DishReqDTO dishReqDTO) {
        DishResDTO resBody = dishService.getDishWithCalories(dishReqDTO);
        return new ResponseEntity<>(
                resBody,
                HttpStatus.OK
        );
    }
}
