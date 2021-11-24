package com.bootcamp.calculadorDeCalorias.repository;

import com.bootcamp.calculadorDeCalorias.model.Ingredientes;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class IngredientesRepository implements IIngredientesRepository {
    List<Ingredientes> alacena;

    public IngredientesRepository(){
        this.alacena = abrirIngredientesJSON();
    }

    @Override
    public List<Ingredientes> abrirIngredientesJSON() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredientes>> typeRef = new TypeReference<>() {};
        List<Ingredientes> ingredientes = null;
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientes;
    }

    @Override
    public Ingredientes getIngredientesByName(String name) {

        return null;
    }
}
