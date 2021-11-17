package com.SocialMeli.dto;

import com.SocialMeli.model.Post;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDTO {
    private int userId;
    private int idPost;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private ProductDetailDTO detail;
    private int category;
    private double price;


    public PostDTO(int userId, int idPost, String date, ProductDetailDTO detail, int category, double price) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        this.userId = userId;
        this.idPost = idPost;
        this.date =  LocalDate.parse(date, formatter);
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public PostDTO(Post post) {
        this.userId = post.getUserId();
        this.idPost = post.getIdPost();
        this.date =  post.getDate();
        this.detail = new ProductDetailDTO(post.getDetail());
        this.category = post.getCategory();
        this.price = post.getPrice();
    }
}
