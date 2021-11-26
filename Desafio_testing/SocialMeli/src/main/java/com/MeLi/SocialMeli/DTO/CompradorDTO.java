package com.MeLi.SocialMeli.DTO;

import com.MeLi.SocialMeli.model.Comprador;
import com.MeLi.SocialMeli.model.Usuario;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class CompradorDTO{

    @NotNull
    @Min(1)
    private int user_id;
    @Size(min=1,max=15)
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
