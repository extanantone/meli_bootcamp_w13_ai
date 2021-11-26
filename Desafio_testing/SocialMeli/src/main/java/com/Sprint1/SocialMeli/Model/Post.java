package com.Sprint1.SocialMeli.Model;

import com.Sprint1.SocialMeli.DTO.PostFullDTO;
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
    private Integer userId;
    private Integer idPost;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Product detail;
    private Integer category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;


    public Post (PostShortDTO postShortDTO) {
        this.userId = postShortDTO.getUserId();
        this.idPost = postShortDTO.getIdPost();
        this.date = postShortDTO.getDate();
        this.detail = new Product(postShortDTO.getDetail());
        this.category = postShortDTO.getCategory();
        this.price = postShortDTO.getPrice();
        this.hasPromo = false;
        this.discount = 0.00;
    }

    public Post (PostFullDTO postFullDTO){
            this.userId = postFullDTO.getUserId();
            this.idPost = postFullDTO.getIdPost();
            this.date = postFullDTO.getDate();
            this.detail = new Product(postFullDTO.getDetail());
            this.category = postFullDTO.getCategory();
            this.price = postFullDTO.getPrice();
            this.hasPromo = postFullDTO.getHasPromo();
            this.discount = postFullDTO.getDiscount();
    }
}
