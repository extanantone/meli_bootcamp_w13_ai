package com.example.calorias.repository;

import com.example.calorias.model.Ingredientes;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
@Repository
public class CaloriasRepositorio implements ICaloriasRepositorio{

    List<Ingredientes> ingredientes;

    List<Ingredientes> abrirIngredientesJson(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredientes>> typeRef = new TypeReference<>() {};
        List<Ingredientes> ingrediente = null;
        try {
            ingrediente = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingrediente;

    }

    public CaloriasRepositorio() {
        this.ingredientes = abrirIngredientesJson();
    }

    public Ingredientes obtenerIngrediente(String nombre) {
        return this.ingredientes.stream().filter(p -> p.getName().toLowerCase().contains(nombre.toLowerCase())).findFirst().orElse(null);
    }
}
