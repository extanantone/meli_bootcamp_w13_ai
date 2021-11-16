package com.example.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDTO {
    private final Integer userId;
    private final Integer idPost;
    private final LocalDate date;
    private final ProductDetailDTO detail;
    private final Integer category;
    private final Double price;

    public PostDTO(Integer userId, Integer idPost, String date, ProductDetailDTO detail, Integer category, Double price) {
        this.userId = userId;
        this.idPost = idPost;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.date = LocalDate.parse(date, formatter);
        this.detail = detail;
        this.category = category;
        this.price = price;
    }
}
