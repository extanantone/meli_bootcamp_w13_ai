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
public class PromocionesDTO extends UsuarioDTO{

    private List<InfoPromoDTO> posts;

    public PromocionesDTO(Integer userId, String userName, List<InfoPromoDTO> posts) {
        super(userId, userName);
        this.posts = posts;
    }
}
