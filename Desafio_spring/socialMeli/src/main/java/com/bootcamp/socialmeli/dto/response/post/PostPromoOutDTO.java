package com.bootcamp.socialmeli.dto.response.post;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostPromoOutDTO extends PostOutDTO{

    private boolean hasPromo;

    private double discount;

    public PostPromoOutDTO(int postId, String date, ProductDTO detail, int category, double price, boolean hasPromo, double discount) {
        super(postId, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
