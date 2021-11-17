package com.example.socialmeli.dto;

import com.example.socialmeli.exception.BadBodyRequestException;
import com.example.socialmeli.model.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public PostDto(Integer userId, Integer postId ,String date, String category, Boolean hasPromo, Double discount, Double price, Product detail) {
        try {
            this.userId = userId;
            this.postId = postId;
            this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            this.category = category;
            this.hasPromo = hasPromo != null ? hasPromo : false;
            this.discount = discount;
            this.price = price;
            this.detail = detail;
        }catch (DateTimeException e){
            throw new BadBodyRequestException("El formato de la fecha no es correcto");
        }
    }
}
