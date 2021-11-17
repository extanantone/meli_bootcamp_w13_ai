package com.bootcamp.SocialMeli.DTO;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromoPDTO extends PublicacionDTO{
    private boolean promo;
    private Double descuento;

    public PromoPDTO(Integer userId, Integer idPost, @JsonFormat(pattern = "dd-MM-yyyy") LocalDate date, DetallePublicacionDTO detalleP, Integer category, Double price, boolean promo, Double descuento) {
        super(userId,idPost, date, detalleP, category, price);
        this.promo = promo;
        this.descuento = descuento;
    }
}
