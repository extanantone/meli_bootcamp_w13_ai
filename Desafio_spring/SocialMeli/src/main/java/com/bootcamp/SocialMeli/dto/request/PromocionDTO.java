package com.bootcamp.SocialMeli.dto.request;

import com.bootcamp.SocialMeli.dto.DetalleProductoDTO;
import com.bootcamp.SocialMeli.dto.PublicacionDTO;
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
public class PromocionDTO extends PublicacionDTO {
    private boolean hasPromo;
    private double discount;

    public PromocionDTO(int userId, int idPost, LocalDate date, DetalleProductoDTO detail, int category, double price, boolean hasPromo, double discount) {
        super(userId, idPost, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
