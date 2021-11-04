package com.bootcamp.calculadora_de_calorias.repository;

import com.bootcamp.calculadora_de_calorias.model.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class IngredienteRepositoryImpl implements IIngredienteRepository{
    private List<Ingrediente> listaIngredientes;

    @Autowired
    public IngredienteRepositoryImpl() {
        this.listaIngredientes = abrirJsonIngredientes();
    }

    public List<Ingrediente> abrirJsonIngredientes(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        List<Ingrediente> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }

    @Override
    public Double getCalorias(String nombreIngrediente) {
        //this.listaIngredientes = abrirJsonIngredientes();
        Ingrediente ingredienteSeleccionado = this.listaIngredientes.stream()
                                                    .filter(x -> x.getName().equalsIgnoreCase(nombreIngrediente))
                                                    .findFirst().orElse(null);

        return ingredienteSeleccionado.getCalories();
    }
}
