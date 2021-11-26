package com.desafio_testing.principal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ListaUsuariosDTO extends UsuarioDTO{
    private List<UsuarioDTO> followers;
    private List<UsuarioDTO> followed;

    public ListaUsuariosDTO(int userId, String userName, List<UsuarioDTO> followers, List<UsuarioDTO> followed) {
        super(userId, userName);
        this.followers = followers;
        this.followed = followed;
    }
}
