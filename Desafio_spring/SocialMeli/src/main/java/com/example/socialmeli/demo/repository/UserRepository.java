package com.example.socialmeli.demo.repository;


import com.example.socialmeli.demo.model.Usuarios;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository implements IUserRepository {

    private Map<Integer, Usuarios> listaUsuarios = new HashMap<>();



    public UserRepository(){

        Usuarios v1 = new Usuarios(1,"Pablo");
        Usuarios v2 = new Usuarios(2,"Rodrigo");
        Usuarios v3 = new Usuarios(3,"Anibal");
        Usuarios v4 = new Usuarios(4,"Rodrigo");

        this.listaUsuarios = obtenerUsuariosPorJson();
/*
        listaUsuarios.put(1,v1);
        listaUsuarios.put(2,v2);
        listaUsuarios.put(3,v3);
        listaUsuarios.put(4,v4); */



    }


    public Map<Integer, Usuarios> obtenerUsuariosPorJson(){

        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:usuarios.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Usuarios>> typeRef = new TypeReference<>() {};
        List<Usuarios> usuarios = null;
        try {
            usuarios = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<Integer, Usuarios> usersInMap = new HashMap<>();
        usersInMap = convertListToMap(usuarios);

        return usersInMap;


    }

    public Map<Integer, Usuarios> convertListToMap(List<Usuarios> userList){

        Map<Integer, Usuarios> usersInMap = new HashMap<>();
        for (Usuarios u: userList) {
            usersInMap.put(u.getId(),u);
        }

        return usersInMap;
    }



    @Override
    public Usuarios crearVendedor(Usuarios v) {
        return null;
    }

    @Override
    public Usuarios obtenerUsuarioPorID(int id) {
        return listaUsuarios.get(id);
    }
}
