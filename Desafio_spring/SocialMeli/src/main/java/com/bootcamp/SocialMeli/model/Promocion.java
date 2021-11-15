package com.bootcamp.SocialMeli.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Promocion extends Publicacion{
    private boolean has_promo;
    private double discount;

    public Promocion(int idPost, LocalDate date, double price, Producto producto, int category, boolean has_promo, double discount) {
        super(idPost, date, price, producto, category);
        this.has_promo = has_promo;
        this.discount = discount;
    }
}
