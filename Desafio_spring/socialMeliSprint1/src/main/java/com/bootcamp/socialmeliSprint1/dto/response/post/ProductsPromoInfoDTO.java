package com.bootcamp.socialmeliSprint1.dto.response.post;

import com.bootcamp.socialmeliSprint1.dto.response.user.BasicUserInfoDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductsPromoInfoDTO extends BasicUserInfoDTO {

    private int promoProductsCount;

    public ProductsPromoInfoDTO(int userId, String userName, int promoProductsCount) {
        super(userId, userName);
        this.promoProductsCount = promoProductsCount;
    }
}
