package com.SprintI.SocialMeli.dtos;

import com.SprintI.SocialMeli.models.Post;
import com.SprintI.SocialMeli.models.Product;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostWithoutDiscountDTO {
    private int userId;
    private int idPost;
    private String date;
    private Product detail;
    private int category;
    private double price;

    public PostWithoutDiscountDTO(Post post) {
        this.userId = post.getUserId();
        this.idPost = post.getIdPost();
        this.date = post.getDate().toString();
        this.detail = post.getDetail();
        this.category = post.getCategory();
        this.price = post.getPrice();
    }

    @Override
    public String toString() {
        return "PostWithoutDiscountDTO{" +
                "userId=" + userId +
                ", idPost=" + idPost +
                ", date='" + date + '\'' +
                ", detail=" + detail +
                ", category=" + category +
                ", price=" + price +
                '}';
    }
}
