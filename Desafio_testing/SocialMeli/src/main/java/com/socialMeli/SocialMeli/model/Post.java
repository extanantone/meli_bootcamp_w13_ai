package com.socialMeli.SocialMeli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.socialMeli.SocialMeli.postDTO.PromoPostInDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class Post{
    @NotNull(message = "no se acepta user_id null")
    @Positive(message = "el user_id debe ser mayor a 0")
    private Integer user_id;

    @NotNull(message = "no se acepta post_id null")
    @Positive(message = "el post_id debe ser mayor a 0")
    private Integer id_post;


    @NotNull(message = "no se acepta una fecha null")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Valid
    private ProductDetails detail;

    @NotNull(message = "no se acepta una category null")
    private Integer category;

    @NotNull(message = "no se acepta price null")
    @Positive(message = "el price debe ser mayor a 0")
    @Max(value = 10000000,message = "el precio maximo es de 10.000.000")
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
