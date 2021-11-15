package com.springlll.CalculadoraCalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springlll.CalculadoraCalorias.model.Ingredientes;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class IngredientesRepository implements IIngredientesRepository{

    List<Ingredientes> ingredientes;

    IngredientesRepository() {
        this.ingredientes = abrirIngredientesJson();
    }

    protected List<Ingredientes> abrirIngredientesJson() {
        File file = null;
        try {
            file = ResourceUtils.getFile(
                    "classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper
                objectMapper = new ObjectMapper();
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
    public List<Ingredientes> abrirIngredientes(String nombre) {
        return this.ingredientes.stream()
                .filter(p ->
                        p.getNombre()
                                .toLowerCase()
                                .contains(
                                        nombre
                                                .toLowerCase()))
                .collect(Collectors.toList());
    }
}




