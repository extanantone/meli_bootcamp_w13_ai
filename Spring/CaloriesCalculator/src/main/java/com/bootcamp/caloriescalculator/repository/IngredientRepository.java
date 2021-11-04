package com.bootcamp.caloriescalculator.repository;

import com.bootcamp.caloriescalculator.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class IngredientRepository implements IIngredientRepository{

    List<Ingredient> ingredients;

    public IngredientRepository() {
        this.ingredients = loadIngredients();
    }

    protected List<Ingredient> loadIngredients() {
        File file = null;
        try {
            file = ResourceUtils.getFile(
                    "classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Ingredient> ingredients = null;
        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    @Override
    public Ingredient getIngredientByName(String name) {
        return this.ingredients.stream()
                .filter(i -> i.getName().equals(name))
                .findAny()
                .orElse(null);
    }
}
