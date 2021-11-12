package com.MeLi.SocialMeli.model;

import com.MeLi.SocialMeli.service.VendedorServiceImplement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vendedor extends Usuario{

    HashMap<Integer,String> seguidores = new HashMap<>();

    public Vendedor(int id, String nombre) {
        super(id, nombre);
    }

    public void setSeguidor(Comprador comprador){
        seguidores.put(comprador.getId(), comprador.getNombre());
    }

    public int getCantSeguidores(){
        return seguidores.size();
    }

    public HashMap<Integer, String> getSeguidores(){
        return seguidores;
    }

}
