package com.example.socialmeli.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@NoArgsConstructor
public class PublicacionPromocion extends Publicacion{

    private boolean hasPromo;
    private double discount;

    public PublicacionPromocion(int userId, int idPost, LocalDate date, Producto detail, int category, double price, boolean hasPromo, double discount) {
        super(userId, idPost, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }


    @Override
    public boolean hasPromo() { return this.hasPromo; }

    @Override
    public void setPromo(boolean promo) { this.hasPromo = promo; }

    @Override
    public double hasDiscount() { return this.discount; }

    @Override
    public void setDiscount(Double discount) { this.discount = discount; }

}
