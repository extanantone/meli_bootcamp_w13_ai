package com.bootcamp.SocialMeli.dto;

import com.bootcamp.SocialMeli.model.Post;
import com.bootcamp.SocialMeli.model.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDTO {

    int userId;
    int idPost;
    LocalDate date;
    ProductDetailDTO detail;
    int category;
    double price;


    public PostDTO(Post post) {
        this.userId = post.getUserId();
        this.idPost = post.getId();
        this.date = post.getDate();
        this.detail = new ProductDetailDTO(post.getProductDetail());
        this.category = post.getCategory();
        this.price = post.getPrice();

    }
}
