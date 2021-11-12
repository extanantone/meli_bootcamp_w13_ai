package com.bootcamp.SocialMeli.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SeguidosDTO extends UsuarioDTO {
    private List<UsuarioDTO> followed;

    public SeguidosDTO(Integer userId, String userName, List<UsuarioDTO> followed) {
        super(userId, userName);
        this.followed = followed;
    }

}
