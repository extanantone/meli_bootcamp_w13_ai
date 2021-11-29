package com.bootcamp.SocialMeli.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PromoPublicacion extends Publicacion{
    private boolean promo;
    private double descuento;

    public PromoPublicacion(Integer userId, Integer idPost, @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy") LocalDate date, DetallePublicacion detalleP, Integer category, Double price, boolean promo, Double descuento) {
        super(userId,idPost, date, detalleP, category, price);
        this.promo = promo;
        this.descuento = descuento;
    }
}
