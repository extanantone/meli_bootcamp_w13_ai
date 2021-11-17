package com.bootcamp.calculadoraDeCalorias.service;

import com.bootcamp.calculadoraDeCalorias.model.Food;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FoodRepository implements IFoodRepository {
    List<Food> foodList;

    public FoodRepository(List<Food> foodList) {
        this.foodList = openJsonFood();
    }

    public Map<String, Integer> foodCalories(Map<String, Integer> dish) {
        Map<String, Integer> dishCalories = new HashMap<>();

        if (dish != null) {
            dish.forEach((k, v) -> {
                Integer calories = foodList.stream().filter(x -> x.getName() == k).findFirst().get().getCalories();
                dishCalories.put(k, calories);
            });
        }
        return dishCalories;
    }

    protected List<Food> openJsonFood() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Food>> typeRef = new TypeReference<>() {
        };
        List<Food> foods = null;
        try {
            foods = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return foods;
    }
}