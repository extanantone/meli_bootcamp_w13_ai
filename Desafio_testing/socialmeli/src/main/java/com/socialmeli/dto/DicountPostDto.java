package com.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DicountPostDto extends PostDto{
    private boolean hasDiscount;
    private double discount;


    public DicountPostDto(int idUser, int idPost, String date, DetailDto detail, int category, double price, boolean hasDiscount, double discount) {
        super(idUser,idPost,date,detail,category,price);
        this.discount = discount;
        this.hasDiscount = hasDiscount;
    }
}
