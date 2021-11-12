package com.MeLi.SocialMeli.DTO;

import com.MeLi.SocialMeli.model.Comprador;
import com.MeLi.SocialMeli.model.Usuario;

public class CompradorDTO{

    private int id;
    private String nombre;

    public CompradorDTO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
