package com.example.socialmeli.demo.repository;


import com.example.socialmeli.demo.model.Usuarios;

public interface IUserRepository {

    public Usuarios crearVendedor(Usuarios v);

    public Usuarios obtenerUsuarioPorID(int id);




}
