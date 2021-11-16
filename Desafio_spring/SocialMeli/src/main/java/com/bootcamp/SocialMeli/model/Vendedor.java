package com.bootcamp.SocialMeli.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Vendedor extends Usuario{
    private List<Publicacion> publicaciones;

    public Vendedor(int userId, String userName, List<Publicacion> publicaciones) {
        //super(userId, userName);
        this.publicaciones = publicaciones;
    }

}
