package com.bootcamp.CalCalorias.Repository;

import com.bootcamp.CalCalorias.Model.Ingredientes;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredienteRepository implements IIngredienteRepository{

    List<Ingredientes> baseIngedientes;

    IngredienteRepository(){
        this.baseIngedientes = abrirIngedientes();
    }

    List<Ingredientes> abrirIngedientes(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredientes>> typeRef = new TypeReference<>() {};
        List<Ingredientes> ingredientes = null;
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientes;
    }

    @Override
    public Ingredientes getNombreIngrediente(String nombre) {
        Optional<Ingredientes> ingre = baseIngedientes.stream()
                .filter(ingredientes -> ingredientes.getNombre().equals(nombre)).findFirst();
        Ingredientes ingrediente = null;
        if (ingre.isPresent())
            ingrediente = ingre.get();
        return ingrediente;
    }
}
