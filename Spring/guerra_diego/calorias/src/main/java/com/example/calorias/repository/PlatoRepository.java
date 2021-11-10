package com.example.calorias.repository;

import com.example.calorias.model.Ingrediente;
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
public class PlatoRepository implements IPlatoRepository{

    List<Ingrediente> ingredientes;

    PlatoRepository(){
        this.ingredientes = abrirIngredientes();
    }

    protected List<Ingrediente> abrirIngredientes(){
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
    public Ingrediente buscarIngredientes(String nombre) {

        return this.ingredientes.stream()
                .filter(i -> i.getName().equals(nombre))
                .findFirst()
                .orElse(null);

/*

        return this.ingredientes.stream()
                .filter(i -> i.getName().equals(listIngredientes.stream().map(Ingrediente::getName)))
                .collect(Collectors.toList());
                */
    }
}
