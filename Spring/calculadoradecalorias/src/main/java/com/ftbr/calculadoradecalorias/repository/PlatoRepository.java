package com.ftbr.calculadoradecalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftbr.calculadoradecalorias.model.Ingrediente;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlatoRepository implements IPlatoRepository {
    List<Ingrediente> listaIngredientes = new ArrayList<>();

    public PlatoRepository() {
        this.listaIngredientes = cargarIngredientesJson();
    }


    @Override
    public int getCalorias(String nombre) {

        Ingrediente ingrediente = listaIngredientes.stream()
                .filter(i -> i.getName().equals(nombre))
                .findFirst()
                .orElse(null);
        return ingrediente == null ? 0 : ingrediente.getCalories();
    }

    private List<Ingrediente> cargarIngredientesJson() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<List<Ingrediente>>() {
        };
        List<Ingrediente> ingredientes = null;
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientes;
    }
}
