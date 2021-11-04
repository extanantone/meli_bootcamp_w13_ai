package com.miprimerproyecto.pruebaspring.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miprimerproyecto.pruebaspring.model.Ingrediente;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class IngredienteRepository implements  IIngredienteRepository{

    List<Ingrediente> ingredienteList;

    IngredienteRepository(){ this.ingredienteList = abrirIngredienteJson();}


    protected List<Ingrediente> abrirIngredienteJson(){
        File file = null;
        try {
            file = ResourceUtils.getFile(
                    "classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        List<Ingrediente> ingrediente = null;
        try {
            ingrediente = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingrediente;
    }

    @Override
    public Ingrediente getIngredientes(String name) {

        return this.ingredienteList.stream()
                .filter(ingrediente -> ingrediente.getName().toLowerCase()
                                .equals(name.toLowerCase())).findFirst().orElse(null);

    }
}
