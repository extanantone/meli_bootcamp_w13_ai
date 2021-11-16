package com.example.socialmeli.demo.mapper;

import com.example.socialmeli.demo.dto.DTOUsuario;
import com.example.socialmeli.demo.model.Usuarios;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public static Usuarios DTOUsuarioToUsuario (DTOUsuario u){

        Usuarios usuario = new Usuarios();
        usuario.setId(u.getUserId());
        usuario.setUserName(u.getUserName());

        return usuario;
    }

    public static DTOUsuario UsuarioTODtoUsuario (Usuarios u){

        DTOUsuario usuario = new DTOUsuario();
        usuario.setUserId(u.getId());
        usuario.setUserName(u.getUserName());

        return usuario;
    }


}
