package com.bootcamp.SocialMeli.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Usuario {
    private int userId;
    private String userName;
    private List<Usuario> vendedoresSeguidos;  //los vendedores a los cuales este usuario sigue
    private List<Post> publicaciones;

    public Usuario(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.vendedoresSeguidos = new ArrayList<>();
        this.publicaciones = new ArrayList<>();
    }

    public Usuario(int userId, String userName, List<Usuario> vendedoresSeguidos, List<Post> publicaciones) {
        this.userId = userId;
        this.userName = userName;
        this.vendedoresSeguidos = vendedoresSeguidos;
        this.publicaciones = publicaciones;
    }

    public void seguirVendedor(Usuario vendedor){
        this.vendedoresSeguidos.add(vendedor);
    }

    public boolean dejarDeSeguirVendedor(Usuario vendedor){
        return this.vendedoresSeguidos.remove(vendedor);
    }
}
