package com.example.bootcamp.comida.repository;

import com.example.bootcamp.comida.model.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class IngredienteRepository implements IIngredienteRepository{

    public List<Ingrediente> ingredientesDisponibles;

    public IngredienteRepository(){
        this.ingredientesDisponibles = obtenerIngredientesPorJson();
    }


    public List<Ingrediente> obtenerIngredientesPorJson(){

        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        List<Ingrediente> ingredientes = null;
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientes;


    }


    @Override
    public List<Ingrediente> traerIngredientes() {
        return ingredientesDisponibles;
    }

    @Override
    public int obtenerCaloriasPorNombreIngrediente(String nombreIngrediente) {

        int calorias=0;
        Ingrediente ing = new Ingrediente();

        ing = ingredientesDisponibles.stream().filter(i -> i.getName().toLowerCase().equals(nombreIngrediente.toLowerCase()))
                .findFirst().orElse(null);

        if(ing != null){
            calorias = ing.getCalories();
        }

        return calorias;

    }


}
