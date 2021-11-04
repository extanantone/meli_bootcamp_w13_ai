package com.bootcamp.calorias.service;

import com.bootcamp.calorias.dto.DTOCalories;
import com.bootcamp.calorias.dto.DTOIngrediente;
import com.bootcamp.calorias.dto.DTOPlato;
import com.bootcamp.calorias.model.Ingredient;
import com.bootcamp.calorias.repository.ICaloriesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaloriesService implements ICaloriesService{

    ICaloriesRepository repository;

    public CaloriesService(ICaloriesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DTOCalories> getCalories(List<DTOPlato> platos) {
        List<DTOCalories> respuesta = new ArrayList<>();

        for (DTOPlato p: platos){
            double caloriasTotales = 0;
            List<Ingredient> ingredientesYCalorias = new ArrayList();
            for (DTOIngrediente i: p.getIngredientes()){
                double caloriasIngrediente = repository.getCalories(i.getName()) * i.peso / 100;
                caloriasTotales += caloriasIngrediente;
                ingredientesYCalorias.add(new Ingredient(i.getName(), caloriasIngrediente));
            }
            respuesta.add(new DTOCalories(caloriasTotales, ingredientesYCalorias, "a definir"));
        }
        return respuesta;
    }
}
