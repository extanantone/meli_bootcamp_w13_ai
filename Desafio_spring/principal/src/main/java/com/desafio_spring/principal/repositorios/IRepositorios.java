package com.desafio_spring.principal.repositorios;

import com.desafio_spring.principal.modelo.Usuario;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @param <K> significa el formato de la collection a llenar
 */
public interface IRepositorios<K> {

    default K leerArchivo(String nombreArchivo){

        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:".concat(nombreArchivo));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<K> typeRef = new TypeReference<>() {};
        K usuariosDefecto = null;
        try {
            usuariosDefecto = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuariosDefecto;
    }

    public void iniciarManual();
}
