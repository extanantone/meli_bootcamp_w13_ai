package com.bootcamp.calorias.repository;

import com.bootcamp.calorias.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CaloriesRepository implements ICaloriesRepository{
    @Override
    public double getCalories(String nombre) {
        cargarIngredientes();
        System.out.println(this.ingredientes);
        for (Ingredient i:ingredientes){
            if (i.getName().equals(nombre)){
                return i.getCalories();
            }
        }
        return 0;
    }


    private List<Ingredient> ingredientes = new ArrayList<>();

    public void cargarIngredientes() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Ingredient> characters = null;
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
