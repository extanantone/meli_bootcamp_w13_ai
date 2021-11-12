package com.bootcamp.SocialMeli.Mapper;

import com.bootcamp.SocialMeli.DTO.UsuarioDTO;
import com.bootcamp.SocialMeli.Model.Usuario;

public class UsuarioMapper {

    public static UsuarioDTO UsuarioToUsuarioDTO(Usuario usuario){
        return new UsuarioDTO(usuario.getUserId(), usuario.getUserName());
    }
}
