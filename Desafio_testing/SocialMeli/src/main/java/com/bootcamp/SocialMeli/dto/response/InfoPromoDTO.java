package com.bootcamp.SocialMeli.dto.response;

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
public class InfoPromoDTO extends PublicacionDTO {
    private Boolean hasPromo;
    private Double discount;

    public InfoPromoDTO(Integer idPost, LocalDate date, DetalleProductoDTO detail, Integer category, Double price, Boolean hasPromo, Double discount) {
        super(idPost, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
