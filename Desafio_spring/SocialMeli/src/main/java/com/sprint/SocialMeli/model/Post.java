package com.sprint.SocialMeli.model;

import com.sprint.SocialMeli.dto.in.PostDtoIn;
import com.sprint.SocialMeli.dto.in.PromoPostDtoIn;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class Post {
    int userId;
    int idPost;
    LocalDate date;
    int productId;
    String productName;
    String type;
    String brand;
    String color;
    String notes;
    int category;
    double price;
    boolean hasPromo;
    double discount;

    public Post(PostDtoIn postDtoIn) {
        userId = postDtoIn.getUserId();
        idPost = postDtoIn.getIdPost();
        date = postDtoIn.getDate();
        productId = postDtoIn.getDetail().getProductId();
        productName = postDtoIn.getDetail().getProductName();
        type = postDtoIn.getDetail().getType();
        brand = postDtoIn.getDetail().getBrand();
        color = postDtoIn.getDetail().getColor();
        category = postDtoIn.getCategory();
        price = postDtoIn.getPrice();
        hasPromo = false;
        discount = 0;
    }

    public Post(PromoPostDtoIn promoPostDtoIn) {
        userId = promoPostDtoIn.getUserId();
        idPost = promoPostDtoIn.getIdPost();
        date = promoPostDtoIn.getDate();
        productId = promoPostDtoIn.getDetail().getProductId();
        productName = promoPostDtoIn.getDetail().getProductName();
        type = promoPostDtoIn.getDetail().getType();
        brand = promoPostDtoIn.getDetail().getBrand();
        color = promoPostDtoIn.getDetail().getColor();
        category = promoPostDtoIn.getCategory();
        price = promoPostDtoIn.getPrice();
        hasPromo = promoPostDtoIn.isHasPromo();
        discount = promoPostDtoIn.getDiscount();
    }


}
