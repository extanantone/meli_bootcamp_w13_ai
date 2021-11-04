package com.bootcamp.caloriescalculator.service;

import com.bootcamp.caloriescalculator.dto.IngredientReqDTO;
import com.bootcamp.caloriescalculator.dto.IngredientResDTO;
import com.bootcamp.caloriescalculator.dto.DishReqDTO;
import com.bootcamp.caloriescalculator.dto.DishResDTO;
import com.bootcamp.caloriescalculator.model.Ingredient;
import com.bootcamp.caloriescalculator.repository.IIngredientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DishService implements IDishService {

    IIngredientRepository ingredientRepository;

    public DishService(IIngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public DishResDTO getDishWithCalories(DishReqDTO dishReqDTO) {
        DishResDTO dishResDTO = new DishResDTO();
        dishResDTO.setName(dishReqDTO.getName());
        dishResDTO.setIngredients(new ArrayList<>());
        dishResDTO.setTotalCalories(0.0);
        dishResDTO.setMostCaloricIngredient(new IngredientResDTO("", 0));
        for (IngredientReqDTO ingredientReqDTO: dishReqDTO.getIngredients()) {
            Ingredient ingredient = this.ingredientRepository.getIngredientByName(ingredientReqDTO.getName());
            IngredientResDTO ingredientResDTO = new IngredientResDTO(ingredient.getName(), ingredient.getCalories());
            dishResDTO.getIngredients().add(ingredientResDTO);
            double ingredientCalories = (double) ingredientResDTO.getCalories() * ingredientReqDTO.getWeight() / 100;
            dishResDTO.setTotalCalories(dishResDTO.getTotalCalories() + ingredientCalories);
            if (ingredientResDTO.getCalories() > dishResDTO.getMostCaloricIngredient().getCalories()) {
                dishResDTO.setMostCaloricIngredient(ingredientResDTO);
            }
        }
        return dishResDTO;
    }
}
