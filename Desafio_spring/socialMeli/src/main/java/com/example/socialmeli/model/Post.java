package com.example.socialmeli.model;

import com.example.socialmeli.exception.BadBodyRequestException;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter

public class Post {
    private static Integer postIdCount = 1;
    private Integer userId, postId;
    private String category;
    private LocalDate date;
    private Boolean hasPromo;
    private Double discount,price;
    private Product detail;

    public Post(Integer userId, LocalDate date, String category, Boolean hasPromo, Double discount, Double price, Product detail) {
            this.userId = userId;
            this.date = date;
            this.category = category;
            this.hasPromo = hasPromo != null ? hasPromo : false;
            this.discount = hasPromo != null ? discount : null;
            this.price = price;
            this.detail = detail;
            this.postId = postIdCount;
            postIdCount++;
    }

    public void setHasPromo(Boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
