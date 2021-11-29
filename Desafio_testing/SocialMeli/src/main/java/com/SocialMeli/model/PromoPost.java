package com.SocialMeli.model;

import com.SocialMeli.dto.PromoPostDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoPost extends Post {
    private boolean hasPromo;
    private Double discount;

    public PromoPost(Integer userId,
                     Integer idPost,
                     LocalDate date,
                     ProductDetail detail,
                     Integer category,
                     Double price,
                     boolean hasPromo,
                     Double discount) {
        super(userId, idPost, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public PromoPost(PromoPostDTO newPromoPost) {
        super(newPromoPost.getIdPost(), newPromoPost.getIdPost(),
                newPromoPost.getDate(),
                new ProductDetail(newPromoPost.getDetail()),
                newPromoPost.getCategory(),
                newPromoPost.getPrice());

        this.hasPromo = newPromoPost.getHasPromo();
        this.discount = newPromoPost.getDiscount();
    }

    public boolean getHasPromo() {
        return hasPromo;
    }
}
