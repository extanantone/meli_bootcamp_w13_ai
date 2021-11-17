package com.example.socialmeli.dto;

import com.example.socialmeli.model.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class NewPostRequestDto {
    private Integer postId, userId;
    private String date,category;
    private boolean hasPromo;
    private Double discount,price;
    private Product detail;

    public NewPostRequestDto(Integer userId, String date, String category, Boolean hasPromo, Double discount, Double price, Product detail) {
        this.userId = userId;
        this.date = date;
        this.category = category;
        this.hasPromo = hasPromo != null ? hasPromo : false;
        this.discount = discount;
        this.price = price;
        this.detail = detail;
    }

    public boolean getHasPromo() {
        return hasPromo;
    }
}
