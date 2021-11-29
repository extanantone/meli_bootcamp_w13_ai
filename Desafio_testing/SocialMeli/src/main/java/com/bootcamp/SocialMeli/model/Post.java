package com.bootcamp.SocialMeli.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Post {
    Integer userId;
    Integer idPost;
    LocalDate date;
    Detail detail;
    Integer category;
    Double price;

    public Post(Integer userId, Integer idPost, LocalDate date, Detail detail, Integer category, Double price) {
        this.userId = userId;
        this.idPost = idPost;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public Post() {
    }
}
