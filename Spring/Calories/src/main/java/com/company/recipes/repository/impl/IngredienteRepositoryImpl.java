package com.company.recipes.repository.impl;

import com.company.recipes.dto.IngredienteDTO;
import com.company.recipes.dto.PlatoDTO;
import com.company.recipes.model.Ingrediente;
import com.company.recipes.repository.IngredienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
@Setter
public class IngredienteRepositoryImpl implements IngredienteRepository {

    @Override
    public List<Ingrediente> getIngredientes(PlatoDTO plato) {
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

    public Integer getCalorias(List<IngredienteDTO> ingredientes) {
        List<Ingrediente> db = this.getData();
        return new Integer(0);
    }

    @Override
    public Ingrediente getIngredienteByName(String name) {
        Ingrediente ingr = getData().stream()
                .filter(ingrBase ->  ingrBase.getName().equals(name))
                .findAny()
                .orElse(null);
        return ingr;
    }

    public List<Ingrediente> getData() {
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
}
