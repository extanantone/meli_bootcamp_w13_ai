package com.example.socialmeli.dto;

import com.example.socialmeli.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class NewPostRequestDto {
    private Integer post_id, user_id;
    private String date,category;
    private boolean has_promo;
    private Double discount,price;
    private Product detail;

    public NewPostRequestDto(Integer user_id, String date, String category, Boolean has_promo, Double discount, Double price, Product detail) {
        this.user_id = user_id;
        this.date = date;
        this.category = category;
        this.has_promo = has_promo != null ? has_promo : false;
        this.discount = discount;
        this.price = price;
        this.detail = detail;
    }

    public boolean getHas_promo() {
        return has_promo;
    }
}
