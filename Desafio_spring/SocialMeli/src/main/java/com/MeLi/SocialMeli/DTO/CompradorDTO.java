package com.MeLi.SocialMeli.DTO;

import com.MeLi.SocialMeli.model.Comprador;
import com.MeLi.SocialMeli.model.Usuario;

public class CompradorDTO{

    private int user_id;
    private String user_name;

    public CompradorDTO(int id, String nombre) {
        this.user_id = id;
        this.user_name = nombre;
    }

    public int getId() {
        return user_id;
    }

    public void setId(int id) {
        this.user_id = id;
    }

    public String getNombre() {
        return user_name;
    }

    public void setNombre(String nombre) {
        this.user_name = nombre;
    }
}
