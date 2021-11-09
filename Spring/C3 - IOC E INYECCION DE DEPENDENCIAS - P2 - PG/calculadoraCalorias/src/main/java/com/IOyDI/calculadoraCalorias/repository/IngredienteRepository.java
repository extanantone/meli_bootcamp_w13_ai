package com.IOyDI.calculadoraCalorias.repository;

import com.IOyDI.calculadoraCalorias.dto.IngredienteDTO;
import com.IOyDI.calculadoraCalorias.entity.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class IngredienteRepository implements IIngredienteRepository {

    List<Ingrediente> ingredientes;

    IngredienteRepository() {
        this.ingredientes = abrirFoodJson();
    }

    protected List<Ingrediente> abrirFoodJson() {
        File file = null;
        try {
            file = ResourceUtils.getFile(
                    "classpath:food.json");
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
    public List<Ingrediente> getAllIngredientes() {
        return this.ingredientes;
    }

    @Override
    public Ingrediente getIngredienteByName(String nombre) {
        return this.ingredientes.stream().filter(i->i.getName().toLowerCase().equals(nombre.toLowerCase())).findFirst().orElse(null);
    }
}
