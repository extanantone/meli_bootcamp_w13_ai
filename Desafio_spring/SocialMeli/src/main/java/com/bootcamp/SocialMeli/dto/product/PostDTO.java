package com.bootcamp.SocialMeli.dto.product;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDTO {
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int userId;
    private int idPost;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private DetailDTO detail;
    private int category;
    private double price;

    public PostDTO(int idPost, LocalDate date, DetailDTO detail, int category, double price) {
        this.idPost = idPost;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }
}