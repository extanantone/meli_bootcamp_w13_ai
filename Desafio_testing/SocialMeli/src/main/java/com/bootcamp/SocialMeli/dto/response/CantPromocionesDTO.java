package com.bootcamp.SocialMeli.dto.response;

import com.bootcamp.SocialMeli.dto.UsuarioDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CantPromocionesDTO extends UsuarioDTO {
    private Integer promoProductsCount;

    public CantPromocionesDTO(Integer userId, String userName, Integer promoProductsCount) {
        super(userId, userName);
        this.promoProductsCount = promoProductsCount;
    }
}
