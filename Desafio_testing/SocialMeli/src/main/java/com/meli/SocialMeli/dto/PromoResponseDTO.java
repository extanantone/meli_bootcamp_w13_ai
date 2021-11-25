package com.meli.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PromoResponseDTO extends PostDTO implements Serializable {
    private boolean hasPromo;
    private double discount;

    public PromoResponseDTO(int idPost, LocalDate date, int category, double price, ProductDTO detail, boolean hasPromo, double discount) {
        super(idPost, date, category, price, detail);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
