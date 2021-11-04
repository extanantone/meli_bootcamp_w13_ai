package com.c3.p2.repository;

import com.c3.p2.model.Ingrediente;
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
public class IngredienteRepository implements IIngredienteRepository {
    List<Ingrediente> ingredientes;

    public IngredienteRepository(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        }
        catch (IOException e) {
            e.printStackTrace();
            ingredientes = new ArrayList<>();
        }
        System.out.print(String.valueOf(ingredientes.size()));
    }

    @Override
    public List<Ingrediente> obtenerIngredientes() {
        return ingredientes;
    }
}
