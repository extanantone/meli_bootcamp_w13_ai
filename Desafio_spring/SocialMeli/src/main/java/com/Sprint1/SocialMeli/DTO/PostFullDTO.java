package com.Sprint1.SocialMeli.DTO;

import com.Sprint1.SocialMeli.Model.Post;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostFullDTO {
    private int userId;
    private int idPost;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO detail;
    private String category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;

    public PostFullDTO(Post post){
        this.userId = post.getUserId();
        this.idPost = post.getIdPost();
        this.date = post.getDate();
        this.detail = new ProductDTO(post.getDetail());
        this.category = post.getCategory();
        this.price = post.getPrice();
        this.hasPromo = post.getHasPromo();
        this.discount = post.getDiscount();
    }
}
