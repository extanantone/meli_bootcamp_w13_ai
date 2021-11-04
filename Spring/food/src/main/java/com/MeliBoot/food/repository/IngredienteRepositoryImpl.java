package com.MeliBoot.food.repository;

import com.MeliBoot.food.models.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class IngredienteRepositoryImpl implements  IngredienteRepository{

    List<Ingrediente> baseDeDatosIngredientes;

    protected IngredienteRepositoryImpl() {
        this.baseDeDatosIngredientes = abrirIngredientesJSON();
    }

    List<Ingrediente> abrirIngredientesJSON() {
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
    public List<Ingrediente> getIngredientesBD() {
        return baseDeDatosIngredientes;
    }
}
