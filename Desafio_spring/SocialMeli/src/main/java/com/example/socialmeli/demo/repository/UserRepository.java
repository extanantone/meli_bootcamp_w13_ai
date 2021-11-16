package com.example.socialmeli.demo.repository;


import com.example.socialmeli.demo.model.Usuarios;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository implements IUserRepository {

    private Map<Integer, Usuarios> listaUsuarios = new HashMap<>();



    public UserRepository(){

        Usuarios v1 = new Usuarios(1,"Pablo");
        Usuarios v2 = new Usuarios(2,"Rodrigo");
        Usuarios v3 = new Usuarios(3,"Anibal");
        Usuarios v4 = new Usuarios(4,"Rodrigo");

        listaUsuarios.put(1,v1);
        listaUsuarios.put(2,v2);
        listaUsuarios.put(3,v3);
        listaUsuarios.put(4,v4);

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
