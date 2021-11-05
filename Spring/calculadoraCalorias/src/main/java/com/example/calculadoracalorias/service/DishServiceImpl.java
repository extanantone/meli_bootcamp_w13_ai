package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.DishDTO;
import com.example.calculadoracalorias.dto.IngredientDTO;
import com.example.calculadoracalorias.repository.IngredientRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DishServiceImpl implements DishService{

    private IngredientRepo ingredientRepo;

    public DishServiceImpl(IngredientRepo ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public DishDTO calculateCalories(DishDTO dish) {
        DishDTO response = new DishDTO();
        List<IngredientDTO> newList = new ArrayList<>();
        List<IngredientDTO> xx = dish.getIngredients();
        double sumIngredients = 0;
        double moreCaloric = 0;
        for (IngredientDTO ingredient : xx) {
            IngredientDTO element = findeIngredient(ingredient.getName());
            if (element != null){
                element.setCaloriesByWeight(ingredient.getWeight() * element.getCalories() / 100);
                element.setWeight(ingredient.getWeight());
                newList.add(element);
                sumIngredients +=  element.getCaloriesByWeight();
            }

            if(element.getCaloriesByWeight() > moreCaloric){
                response.setMoreCaloricIngredient(element.getName());

            }
        }

        response.setName(dish.getName());
        response.setIngredients(newList);
       return response ;
    }


    public IngredientDTO findeIngredient( String name){
       return ingredientRepo.findIngredientByName(name);
    }
}
