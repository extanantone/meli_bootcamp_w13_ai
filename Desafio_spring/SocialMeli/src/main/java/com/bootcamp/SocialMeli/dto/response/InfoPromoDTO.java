package com.bootcamp.SocialMeli.dto.response;

import com.bootcamp.SocialMeli.dto.DetalleProductoDTO;
import com.bootcamp.SocialMeli.dto.PublicacionDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class InfoPromoDTO extends PublicacionDTO {
    private boolean has_promo;
    private double discount;

    public InfoPromoDTO(int idPost, LocalDate date, DetalleProductoDTO detail, int category, double price, boolean has_promo, double discount) {
        super(idPost, date, detail, category, price);
        this.has_promo = has_promo;
        this.discount = discount;
    }
}
