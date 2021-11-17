package com.bootcamp.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter @Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
public class PostDTO {
    Integer userId;
    Integer idPost;
//    @JsonFormat(pattern="dd-MM-YYYY")
    String date;
    DetailDTO detail;
    Integer category;
    Double price;

    public PostDTO(Integer userId, Integer idPost, String date, DetailDTO detail, Integer category, Double price) {
        this.userId = userId;
        this.idPost = idPost;
//        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }
}
