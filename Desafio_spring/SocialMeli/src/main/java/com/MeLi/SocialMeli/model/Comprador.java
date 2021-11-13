package com.MeLi.SocialMeli.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Comprador extends Usuario{


    HashMap<Integer, String> seguidos = new HashMap<>();

    public Comprador(int id, String nombre){
        super(id,nombre);
    }

    public void setSeguido(Vendedor vendedor){
        seguidos.put(vendedor.getId(), vendedor.getNombre());
    }

    public HashMap<Integer, String> getSeguidos(){
        return seguidos;
    }
}
