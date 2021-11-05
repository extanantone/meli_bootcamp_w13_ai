package com.C3P2VIVO.CalculadoraCalorias.repository;

import com.C3P2VIVO.CalculadoraCalorias.dto.IngredienteDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredienteRepository implements IIngredienteRepository{
    private List<IngredienteDTO> database;

    public IngredienteRepository(){
        database = loadDataBase();
    }

    @Override
    public IngredienteDTO findIngredientByName(String name) {
        Optional<IngredienteDTO> first = database.stream().filter(ingredienteDTO -> ingredienteDTO.getName().equals(name)).findFirst();
        IngredienteDTO result = null;
        if (first.isPresent())
            result = first.get();
        return result;
    }

    private List<IngredienteDTO> loadDataBase(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredienteDTO>> typeRef = new TypeReference<>(){};
        List<IngredienteDTO> priceDTOS = null;

        try {
            priceDTOS = objectMapper.readValue(file, typeRef);
        }catch (IOException e){
            e.printStackTrace();
        }

        return priceDTOS;
    }
}
