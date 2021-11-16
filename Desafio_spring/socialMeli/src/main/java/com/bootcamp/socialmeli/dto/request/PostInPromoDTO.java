package com.bootcamp.socialmeli.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostInPromoDTO extends PostInDTO{

    private boolean hasPromo;

    private double discount;

    public PostInPromoDTO(int userId, int IdPost, String date, ProductInDTO detail,
                          int category, double price, boolean hasPromo, double discount) {
        super(userId, IdPost, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
