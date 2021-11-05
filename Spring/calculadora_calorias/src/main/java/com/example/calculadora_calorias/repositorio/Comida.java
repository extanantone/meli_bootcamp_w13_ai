package com.example.calculadora_calorias.repositorio;

import com.example.calculadora_calorias.dto.IngredienteDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
@Getter
@Setter
public class Comida {
    private final List<IngredienteDTO> database;

    public Comida() {
        this.database = loadDataBase();
    }

    public IngredienteDTO buscarIngredientePorNombre(String nombre){
        for (IngredienteDTO ingrediente: this.database){
            if (ingrediente.getNombre().equalsIgnoreCase(nombre)){
                return ingrediente;
            }
        }
        return null;
    }
    private List<IngredienteDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredienteDTO>> typeRef = new TypeReference<>() {};
        List<IngredienteDTO> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
