package com.example.plato.repository;

import com.example.plato.model.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class CaloriasRepository implements ICaloriasRepository{

    List<Ingrediente> ingredientes = new ArrayList<>();

    public CaloriasRepository() {
        this.ingredientes = getlistJson();
    }

    public List<Ingrediente> getlistJson () {

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
    public Ingrediente getIngrediente(String name) {
        System.out.println(ingredientes);
        Ingrediente ingrediente= ingredientes.stream().filter(i -> i.getName().compareToIgnoreCase(name) == 0).findFirst().get();

        return ingrediente;
    }
}

