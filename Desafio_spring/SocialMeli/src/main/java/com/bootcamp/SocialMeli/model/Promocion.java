package com.bootcamp.SocialMeli.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Promocion extends Publicacion{
    private boolean hasPromo;
    private double discount;

    public Promocion(int idPost, LocalDate date, double price, Producto producto, int category, boolean hasPromo, double discount) {
        super(idPost, date, price, producto, category);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
