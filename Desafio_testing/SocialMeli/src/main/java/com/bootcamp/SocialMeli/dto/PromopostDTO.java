package com.bootcamp.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class PromopostDTO extends PostDTO{

    private boolean has_promo;
    private double discount;

    public PromopostDTO(int user_id, int id_post, @JsonFormat(pattern = "dd-MM-yyyy") LocalDate date, DetailDTO detail, int category, double price, boolean has_promo, double discount) {
        super(user_id, id_post, date, detail, category, price);
        this.has_promo = has_promo;
        this.discount = discount;
    }
}
