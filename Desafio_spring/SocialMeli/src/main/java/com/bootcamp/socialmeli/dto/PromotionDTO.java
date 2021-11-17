package com.bootcamp.socialmeli.dto;

import com.bootcamp.socialmeli.model.Promotion;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PromotionDTO extends PostDTO implements Serializable {
    private boolean hasPromo;
    private double discount;

    public PromotionDTO(Long idPost, LocalDate date, PostProductDTO detail, Integer category, Double price, boolean hasPromo, double discount) {
        super(idPost, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public PromotionDTO() {
    }
}

