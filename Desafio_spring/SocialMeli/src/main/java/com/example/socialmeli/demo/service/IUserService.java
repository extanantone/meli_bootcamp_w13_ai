package com.example.socialmeli.demo.service;

import com.example.socialmeli.demo.dto.DTOUsuario;
import com.example.socialmeli.demo.model.Usuarios;

public interface IUserService {

    public Usuarios createUser(Usuarios v);

    public DTOUsuario getUserByUserId(int id);

}
