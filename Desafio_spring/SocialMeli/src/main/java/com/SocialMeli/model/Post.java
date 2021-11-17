package com.SocialMeli.model;

import com.SocialMeli.dto.PostDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Post {
    private int userId;
    private int idPost;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private ProductDetail detail;
    private int category;
    private double price;

    public Post(PostDTO postDTO) {
        this.userId = postDTO.getUserId();
        this.idPost = postDTO.getIdPost();
        this.date = postDTO.getDate();
        this.detail = new ProductDetail(postDTO.getDetail());
        this.category = postDTO.getCategory();
        this.price = postDTO.getPrice();
    }
}
