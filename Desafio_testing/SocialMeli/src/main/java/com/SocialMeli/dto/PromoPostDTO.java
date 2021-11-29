package com.SocialMeli.dto;

import com.SocialMeli.model.PromoPost;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.format.DateTimeFormatter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoPostDTO extends PostDTO {
    private boolean hasPromo;
    private Double discount;

    public PromoPostDTO(Integer userId,
                        Integer idPost,
                        String date,
                        ProductDetailDTO detail,
                        Integer category,
                        Double price,
                        boolean hasPromo,
                        Double discount) {
        super(userId, idPost, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public PromoPostDTO(PromoPost newPromoPost) {
        super(newPromoPost.getIdPost(),
                newPromoPost.getIdPost(),
                newPromoPost.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                new ProductDetailDTO(newPromoPost.getDetail()),
                newPromoPost.getCategory(),
                newPromoPost.getPrice());

        this.hasPromo = newPromoPost.getHasPromo();
        this.discount = newPromoPost.getDiscount();
    }

    public boolean getHasPromo() {
        return hasPromo;
    }
}
