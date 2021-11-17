package com.example.socialmeli.model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PromoPost extends Post{
    private final boolean hasPromo;
    private final double discount;

    public PromoPost(Integer idPost, Integer userId, LocalDate date, PostDetail details, Integer category, Double price, boolean hasPromo, double discount) {
        super(idPost, userId, date, details, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
