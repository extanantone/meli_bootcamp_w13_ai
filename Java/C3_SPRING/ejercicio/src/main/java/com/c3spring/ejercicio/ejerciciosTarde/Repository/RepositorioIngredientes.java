package com.c3spring.ejercicio.ejerciciosTarde.Repository;

import com.c3spring.ejercicio.ejerciciosTarde.model.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class RepositorioIngredientes implements IRepositorio {

    private List<Ingrediente> listaIngredientes;

    public RepositorioIngredientes() {
        this.listaIngredientes = leerArchivo();
    }

    public List<Ingrediente> leerArchivo() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {
        };
        List<Ingrediente> Ingredientes = null;
        try {
            Ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Ingredientes;
    }

    @Override
    public List<Ingrediente> obtenerLista() {
        return listaIngredientes;
    }
}
