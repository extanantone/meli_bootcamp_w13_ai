package com.example.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vendedor extends Usuario{
    private List<Publicacion> publicaciones;
    private List<Comprador> seguidores;

    public Vendedor(String name, int user_id) {
        super(name, user_id);
        this.publicaciones = new ArrayList<Publicacion>();
        this.seguidores = new ArrayList<Comprador>();
    }

}
