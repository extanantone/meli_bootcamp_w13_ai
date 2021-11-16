package com.meli.SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Promo extends Post{
    private boolean hasPromo;
    private double discount;

    public Promo(int userId, int idPost, LocalDate date, int category, double price, Product detail, boolean hasPromo, double discount) {
        super(userId, idPost, date, category, price, detail);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

}
