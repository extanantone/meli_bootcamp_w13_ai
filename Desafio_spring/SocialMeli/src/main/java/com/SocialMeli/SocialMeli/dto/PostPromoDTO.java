package com.SocialMeli.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class PostPromoDTO extends PostDTO{
    private Boolean has_promo;
    private Double discount;

    public PostPromoDTO(Integer id_post, LocalDate date, Integer category, Double price, ProductDTO detail, Boolean has_promo, Double discount) {
        super(id_post, date, category, price, detail);
        this.has_promo = has_promo;
        this.discount = discount;
    }

    public PostPromoDTO(Boolean has_promo, Double discount) {
        this.has_promo = has_promo;
        this.discount = discount;
    }
}
