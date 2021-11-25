package com.example.socialmeli.demo.repository;


import com.example.socialmeli.demo.model.Usuarios;

public interface IUserRepository {

    public Usuarios createUser(Usuarios v);

    public Usuarios getUserByUserId(int id);




}
