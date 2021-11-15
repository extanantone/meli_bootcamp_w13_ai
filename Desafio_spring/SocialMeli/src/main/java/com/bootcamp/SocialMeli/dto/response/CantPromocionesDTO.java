package com.bootcamp.SocialMeli.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CantPromocionesDTO extends UsuarioDTO{
    private Integer promo_products_count;

    public CantPromocionesDTO(Integer userId, String userName, Integer promo_products_count) {
        super(userId, userName);
        this.promo_products_count = promo_products_count;
    }
}
