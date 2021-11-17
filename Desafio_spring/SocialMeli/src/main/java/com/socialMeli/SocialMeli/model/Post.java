package com.socialMeli.SocialMeli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.socialMeli.SocialMeli.postDTO.PromoPostInDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Post {
    private Integer user_id;
    private Integer id_post;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDetails detail;
    private Integer category;
    private Double price;
    private Boolean has_promo;
    private Double discount;

    public Post(Integer user_id, Integer id_post,@JsonFormat(pattern = "dd-MM-yyyy") LocalDate date, ProductDetails detail, Integer category, Double price) {
        this.user_id = user_id;
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.has_promo=false;
        this.discount=0.0;
    }

    public Post(PromoPostInDTO promoPostDTO) {
        this.user_id = promoPostDTO.getUser_id();
        this.id_post = promoPostDTO.getId_post();
        this.date = promoPostDTO.getDate();
        this.detail = promoPostDTO.getDetail();
        this.category = promoPostDTO.getCategory();
        this.price = promoPostDTO.getPrice();
        if (promoPostDTO.getHas_promo() != null){
            this.has_promo = promoPostDTO.getHas_promo();
        }else{
            this.has_promo=false;
        }
        if (promoPostDTO.getDiscount() != null){
            this.discount=promoPostDTO.getDiscount();
        }else{
            this.discount=0.0;
        }
    }
}
