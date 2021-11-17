package com.example.socialmeli.dto;

import com.example.socialmeli.model.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class PostDto extends UserDto{
    private Integer postId;
    private String category;
    private LocalDate date;
    private Boolean hasPromo;
    private Double discount,price;
    private Product detail;

    public PostDto(Integer userId, Integer postId, String category, LocalDate date, Boolean hasPromo, Double discount, Double price, Product detail) {
        this.postId = postId;
        this.category = category;
        this.date = date;
        this.hasPromo = hasPromo;
        this.discount = hasPromo != null ? discount : null;
        this.price = price;
        this.detail = detail;
        super.userId = userId;
    }
}
