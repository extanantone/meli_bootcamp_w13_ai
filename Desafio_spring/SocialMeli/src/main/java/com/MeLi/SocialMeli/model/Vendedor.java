package com.MeLi.SocialMeli.model;

import com.MeLi.SocialMeli.service.VendedorServiceImplement;

import java.util.HashMap;
import java.util.List;

public class Vendedor extends Usuario{

    HashMap<Integer,Comprador> seguidores = new HashMap<>();

    public Vendedor(int id, String nombre) {
        super(id, nombre);
    }

    public void setSeguidor(int idVendedor, Comprador comprador){
        seguidores.put(idVendedor,comprador);
    }

    public int getCantSeguidores(){
        return seguidores.size();
    }

    public List<Comprador> getSeguidores(){
        for (Comprador c: seguidores) {

        }
    }
    
}
