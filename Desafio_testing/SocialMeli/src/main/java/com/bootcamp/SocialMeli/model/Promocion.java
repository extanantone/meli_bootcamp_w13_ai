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
    private Boolean hasPromo;
    private Double discount;

    public Promocion(Integer idPost, LocalDate date, Double price, Producto producto, Integer category, Boolean hasPromo, Double discount) {
        super(idPost, date, price, producto, category);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
