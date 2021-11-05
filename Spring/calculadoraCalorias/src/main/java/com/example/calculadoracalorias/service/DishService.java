package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.DishDTO;
import com.example.calculadoracalorias.dto.DishResponseDTO;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

public interface DishService {
     DishDTO calculateCalories(DishDTO dish);

}
