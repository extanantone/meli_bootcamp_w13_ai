package com.desafio_spring.principal.dto;

import com.desafio_spring.principal.modelo.Usuario;
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
public class ListaPublicacionesDTO extends UsuarioDTO{


    private List<PublicacionesDTO> posts;

    public ListaPublicacionesDTO(int userId, String userName, List<PublicacionesDTO> posts) {
        super(userId, userName);
        this.posts = posts;
    }
}
