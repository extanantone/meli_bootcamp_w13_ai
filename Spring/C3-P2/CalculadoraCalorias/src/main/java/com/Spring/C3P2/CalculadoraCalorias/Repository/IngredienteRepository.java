package com.Spring.C3P2.CalculadoraCalorias.Repository;

import com.Spring.C3P2.CalculadoraCalorias.Model.Ingrediente;
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
public class IngredienteRepository implements IIngredienteRepository{

    List<Ingrediente> ingredientes;

    public IngredienteRepository() {
        this.ingredientes = abrirIngredientesJson();
    }

    private List<Ingrediente> abrirIngredientesJson(){
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
    public Ingrediente ObtenerIngrediente(String nombre) {
        return this.ingredientes.stream()
                .filter(i -> i.getName().toLowerCase().contains(nombre.toLowerCase())).findFirst().orElse(null);
    }
}
