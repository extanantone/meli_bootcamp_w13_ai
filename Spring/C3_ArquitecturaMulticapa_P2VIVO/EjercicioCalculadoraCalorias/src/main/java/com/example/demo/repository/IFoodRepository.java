package com.example.demo.repository;

import com.example.demo.models.Food;

import java.util.List;
import java.util.Map;

public interface IFoodRepository {
     Map<String, Integer> foodCalories(Map<String,Integer> dish);
}
