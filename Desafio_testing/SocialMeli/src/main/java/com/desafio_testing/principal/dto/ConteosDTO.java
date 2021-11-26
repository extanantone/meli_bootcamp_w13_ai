package com.desafio_testing.principal.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ConteosDTO extends UsuarioDTO {

    private Integer followersCount;
    private Integer promoProductsCount;
    private Integer productsCount;

    public ConteosDTO(int userId, String userName, Integer followersCount, Integer promoProductsCount, Integer productsCount) {
        super(userId, userName);
        this.followersCount = followersCount;
        this.promoProductsCount = promoProductsCount;
        this.productsCount = productsCount;
    }
}
