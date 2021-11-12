package com.MeLi.SocialMeli.model;

import java.util.HashMap;

public class Usuario {

    private int id;
    private String nombre;

    public Usuario(int id, String nombre){
        this.nombre = nombre;
        this.id = id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }
}
