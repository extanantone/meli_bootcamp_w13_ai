package com.restaurant.service;

import com.restaurant.dto.PlateDto;
import com.restaurant.dto.ResultIngredientDto;
import com.restaurant.dto.ResultPlateDto;
import com.restaurant.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService implements  IFoodService{

    @Autowired
    private IFoodRepository repository;

    @Override
    public ResultPlateDto getIngredientDtoForPlate(PlateDto plate) {
        List<ResultIngredientDto> ingredients = plate.getIngredients().stream()
                .map(it->new ResultIngredientDto(it.getName(),it.getWeight()*(repository.getFootByName(it.getName()).getCalories()/100)))
                .collect(Collectors.toList());
        double calories = ingredients.stream().mapToDouble(ResultIngredientDto::getCalories).sum();
        return new ResultPlateDto(calories,getNameOfPlateWithMaxCalories(ingredients),ingredients);
    }

    private String getNameOfPlateWithMaxCalories(List<ResultIngredientDto> ingredients){
        String name = ingredients.get(0).getName();
        double calories = ingredients.get(0).getCalories();
        for(ResultIngredientDto ing: ingredients){
            if(ing.getCalories()>calories){
                calories = ing.getCalories();
                name = ing.getName();
            }
        }
        return name;
    }
}
