package com.example.socialmeli.demo.service;

import com.example.socialmeli.demo.dto.UsuarioDTO;
import com.example.socialmeli.demo.model.Usuarios;

public interface IUsuarioService {

    public Usuarios createUser(Usuarios v);

    public UsuarioDTO getUserByUserId(int id);

}
