package com.example.socialmeli.demo.repository;


import com.example.socialmeli.demo.model.Usuarios;

public interface IUsuarioRepository {

    public Usuarios crearVendedor(Usuarios v);

    public Usuarios obtenerUsuarioPorID(int id);




}
