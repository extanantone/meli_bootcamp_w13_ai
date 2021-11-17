package com.bootcamp.SocialMeli.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Post {
    Integer userId;
    Integer idPost;
    LocalDate date;
    Detail detail;
    Integer category;
    Double price;
//    Boolean hasPromo = false;
//    Double discount = 0.0;

    public Post(Integer userId, Integer idPost, LocalDate date, Detail detail, Integer category, Double price) {
        this.userId = userId;
        this.idPost = idPost;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

//    public Post(Integer userId, Integer idPost, LocalDate date, Detail detail, Integer category, Double price, Boolean hasPromo, Double discount) {
//        this.userId = userId;
//        this.idPost = idPost;
//        this.date = date;
//        this.detail = detail;
//        this.category = category;
//        this.price = price;
//        this.hasPromo = hasPromo;
//        this.discount = discount;
//    }

}
