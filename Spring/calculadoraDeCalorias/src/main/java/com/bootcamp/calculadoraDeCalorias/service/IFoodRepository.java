package com.bootcamp.calculadoraDeCalorias.service;

import java.util.Map;

public interface IFoodRepository {
    Map<String, Integer> foodCalories(Map<String, Integer> dish);
}