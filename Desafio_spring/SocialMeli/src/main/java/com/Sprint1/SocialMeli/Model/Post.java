package com.Sprint1.SocialMeli.Model;

import com.Sprint1.SocialMeli.DTO.PostShortDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Post{
    private int userId;
    private int idPost;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Product detail;
    private String category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;


    public Post (PostShortDTO postDTO){
        this.userId = postDTO.getUserId();
        this.idPost = postDTO.getIdPost();
        this.date = postDTO.getDate();
        this.detail = new Product(postDTO.getDetail());
        this.category = postDTO.getCategory();
        this.price = postDTO.getPrice();
        this.hasPromo = false;
        this.discount = 0.00;
    }
}
