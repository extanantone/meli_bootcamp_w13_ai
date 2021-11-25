package com.bootcamp.SocialMeli.dto.response;

import com.bootcamp.SocialMeli.dto.UsuarioDTO;
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
public class SeguidoresDTO extends UsuarioDTO {
    private List<UsuarioDTO> followers;

    public SeguidoresDTO(Integer userId, String userName, List<UsuarioDTO> followers) {
        super(userId, userName);
        this.followers = followers;
    }
}
