package com.example.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostListDTO {
    private final Integer idPost;
    private final String date;
    private final ProductDetailDTO detail;
    private final Integer category;
    private final Double price;

    public PostListDTO(Integer idPost, LocalDate date, ProductDetailDTO detail, Integer category, Double price) {
        this.idPost = idPost;
        this.date = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.detail = detail;
        this.category = category;
        this.price = price;
    }
}
