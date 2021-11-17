package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ReqPromotionDTO extends ReqProductDTO implements Serializable {

    private boolean hasPromo;
    private double discount;

    public ReqPromotionDTO(Long idPost, LocalDate date, PostProductDTO detail, Integer category, Double price, Long userId, boolean hasPromo, double discount) {
        super(idPost, date, detail, category, price, userId);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
