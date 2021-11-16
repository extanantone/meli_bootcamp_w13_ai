package com.bootcamp.SocialMeli.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class PromoPost extends Post{

    private boolean hasPromo;
    private double discount;

    public PromoPost(int idUser, int idPost, LocalDate date, Detail detail, int category, double price, boolean hasPromo, double discount) {
        super(idUser, idPost, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
