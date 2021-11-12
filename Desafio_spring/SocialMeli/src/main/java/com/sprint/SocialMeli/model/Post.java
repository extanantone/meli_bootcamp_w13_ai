package com.sprint.SocialMeli.model;

import com.sprint.SocialMeli.dto.in.PostDtoIn;
import com.sprint.SocialMeli.dto.in.PromoPostDtoIn;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class Post {
    int user_id;
    int id_post;
    LocalDate date;
    int product_id;
    String product_name;
    String type;
    String brand;
    String color;
    String notes;
    int category;
    double price;
    boolean has_promo;
    double discount;

    public Post(){
        has_promo = false;
        discount = 0;
    }

    public Post(PostDtoIn postDtoIn){
        user_id = postDtoIn.getUser_id();
        id_post = postDtoIn.getId_post();
        date = LocalDate.parse(postDtoIn.getDate());
        product_id = postDtoIn.getDetail().getProduct_id();
        product_name = postDtoIn.getDetail().getProduct_name();
        type = postDtoIn.getDetail().getType();
        brand = postDtoIn.getDetail().getBrand();
        color = postDtoIn.getDetail().getColor();
        category = postDtoIn.getCategory();
        price = postDtoIn.getPrice();
    }

    public Post(PromoPostDtoIn promoPostDtoIn){
        user_id = promoPostDtoIn.getUser_id();
        id_post = promoPostDtoIn.getId_post();
        date = LocalDate.parse(promoPostDtoIn.getDate());
        product_id = promoPostDtoIn.getDetail().getProduct_id();
        product_name = promoPostDtoIn.getDetail().getProduct_name();
        type = promoPostDtoIn.getDetail().getType();
        brand = promoPostDtoIn.getDetail().getBrand();
        color = promoPostDtoIn.getDetail().getColor();
        category = promoPostDtoIn.getCategory();
        price = promoPostDtoIn.getPrice();
        has_promo = promoPostDtoIn.isHas_promo();
        discount = promoPostDtoIn.getDiscount();
    }

}
