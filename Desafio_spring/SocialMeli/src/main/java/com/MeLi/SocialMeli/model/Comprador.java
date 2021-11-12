package com.MeLi.SocialMeli.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Comprador extends Usuario{


    HashMap<Integer,Vendedor> seguidos = new HashMap<>();

    public Comprador(int id, String nombre){
        super(id,nombre);
    }

    public void setSeguido(int idVendedor, Vendedor vendedor){
        seguidos.put(idVendedor,vendedor);
    }

    public Set<Map.Entry<Integer, Vendedor>> getSeguidos(){
        return seguidos.entrySet();
    }
}
