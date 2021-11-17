package com.socialMeli.socialMeli.mapper;
import com.socialMeli.socialMeli.dto.UsuarioDto;
import com.socialMeli.socialMeli.model.Usuario;
public class SocialMeliMapper {
    public UsuarioDto usuarioAUsuarioDTO(Usuario usuario){
        return new UsuarioDto(usuario.getUser_id(),usuario.getUser_name());
    }
}
