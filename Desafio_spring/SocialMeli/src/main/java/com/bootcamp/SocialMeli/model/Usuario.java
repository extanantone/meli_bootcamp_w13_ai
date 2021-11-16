package com.bootcamp.SocialMeli.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Usuario {
    private int userId;
    private String userName;
    private List<Usuario> vendedoresSeguidos;  //los vendedores a los cuales este usuario sigue
    private List<Usuario> seguidores;
    private List<Publicacion> publicaciones;

    public Usuario() {
        this.userId = 0;
        this.userName = "";
        this.vendedoresSeguidos = new ArrayList<>();
        this.seguidores = new ArrayList<>();
        this.publicaciones = new ArrayList<>();
    }
/*
    public Usuario(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.vendedoresSeguidos = new ArrayList<>();
        this.publicaciones = new ArrayList<>();
    }

    public Usuario(int userId, String userName, List<Usuario> vendedoresSeguidos) {
        this.userId = userId;
        this.userName = userName;
        this.vendedoresSeguidos = vendedoresSeguidos;
        this.publicaciones = new ArrayList<>();
    }*/

    public Usuario(int userId, String userName, List<Usuario> vendedoresSeguidos, List<Usuario> seguidores, List<Publicacion> publicaciones) {
        this.userId = userId;
        this.userName = userName;
        this.vendedoresSeguidos = vendedoresSeguidos;
        this.seguidores = seguidores;
        this.publicaciones = publicaciones;
    }

    public void seguirVendedor(Usuario vendedor){
        this.vendedoresSeguidos.add(vendedor);
    }

    public boolean dejarDeSeguirVendedor(Usuario vendedor){
        return this.vendedoresSeguidos.remove(vendedor);
    }

    public void agregarSeguidor(Usuario seguidor){
        this.seguidores.add(seguidor);
    }

    public boolean eliminarSeguidor(Usuario seguidor){
        return this.seguidores.remove(seguidor);
    }

    public void agregarPublicacion(Publicacion nuevaPublicacion){
        this.publicaciones.add(nuevaPublicacion);
    }

    public boolean isVendedor(){
        return this.publicaciones.size() > 0;
    }
}
