package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.dto.IngredientDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class IngredientRepoImpl implements IngredientRepo {
    private List<IngredientDTO> database;

    public IngredientRepoImpl() {
        database = loadDataBase();
    }

    @Override
    public IngredientDTO findIngredientByName(String name) {
        Optional<IngredientDTO> first = Optional.ofNullable(database.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null));
        IngredientDTO result = null;
        if ( first.isPresent()){
            result = first.get();
        }
        return result;
    }


    private List<IngredientDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientDTO>> typeRef = new TypeReference<>() {};
        List<IngredientDTO> priceDTOS = null;
        try {
            priceDTOS = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return priceDTOS;
    }
}
