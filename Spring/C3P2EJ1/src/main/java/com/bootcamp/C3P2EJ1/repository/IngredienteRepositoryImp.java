package com.bootcamp.C3P2EJ1.repository;

import com.bootcamp.C3P2EJ1.model.Ingrediente;
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
public class IngredienteRepositoryImp implements IIngredienteRepository {
    List<Ingrediente> listaIngredientesBD;

    public IngredienteRepositoryImp() {
        this.listaIngredientesBD = abrirIngredientesJSON();
    }

    protected List<Ingrediente> abrirIngredientesJSON() {
        File file = null;
        try {
            file = ResourceUtils.getFile(
                    "classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {
        };
        List<Ingrediente> ingredientes = null;
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientes;
    }

    @Override
    public List<Ingrediente> buscarIngredientes(String nombre) {
        return this.listaIngredientesBD.stream().
                filter(ingrediente -> ingrediente.getName().toLowerCase().equals(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }
}
