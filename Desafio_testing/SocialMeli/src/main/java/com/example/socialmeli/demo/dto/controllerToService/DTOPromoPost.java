package com.example.socialmeli.demo.dto.controllerToService;

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
public class DTOPromoPost extends DTOPost {

    private boolean hasPromo;
    private double discount;

    public DTOPromoPost(int userId, int idPost, LocalDate date, DTOProduct detail, int category, double price, boolean hasPromo, double discount) {
        super(userId, idPost, date, detail, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }



}
