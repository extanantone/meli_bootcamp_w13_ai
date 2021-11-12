package com.example.desafiospring.demo.repository;

import com.example.desafiospring.demo.model.Usuarios;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class VendedorRepository implements IVendedorRepository{

    private Map<Integer, Usuarios> listaVendedores = new HashMap<>();



    public VendedorRepository(){

        Usuarios v1 = new Usuarios(1,"Pablo");
        Usuarios v2 = new Usuarios(2,"Rodrigo");
        Usuarios v3 = new Usuarios(3,"Anibal");
        Usuarios v4 = new Usuarios(4,"Rodrigo");

        listaVendedores.put(1,v1);
        listaVendedores.put(2,v2);
        listaVendedores.put(3,v3);
        listaVendedores.put(4,v4);

    }


    @Override
    public Usuarios crearVendedor(Usuarios v) {
        return null;
    }

    @Override
    public Usuarios obtenerVendedorPorID(int id) {
        return listaVendedores.get(id);
    }
}
