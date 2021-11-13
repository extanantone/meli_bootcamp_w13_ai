package com.MeLi.SocialMeli.model;

import java.util.HashMap;

public class Usuario {

    private int user_id;
    private String user_name;

    public Usuario(int user_id, String user_name){
        this.user_id = user_id;
        this.user_name = user_name;
    }

    public void setId(int user_id){
        this.user_id = user_id;
    }

    public int getId(){
        return this.user_id;
    }

    public void setNombre(String nombre){
        this.user_name = user_name;
    }

    public String getNombre(){
        return this.user_name;
    }
}
