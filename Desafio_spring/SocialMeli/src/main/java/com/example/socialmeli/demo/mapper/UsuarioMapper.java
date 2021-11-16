package com.example.socialmeli.demo.mapper;

import com.example.socialmeli.demo.dto.DTOUsuario;
import com.example.socialmeli.demo.model.Usuarios;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public static Usuarios DTOUsuarioToUsuario (DTOUsuario u){

        Usuarios usuario = new Usuarios();
        usuario.setId(u.getUser_id());
        usuario.setUsername(u.getUser_name());

        return usuario;
    }

    public static DTOUsuario UsuarioTODtoUsuario (Usuarios u){

        DTOUsuario usuario = new DTOUsuario();
        usuario.setUser_id(u.getId());
        usuario.setUser_name(u.getUsername());

        return usuario;
    }


}
