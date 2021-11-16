package com.sprint.SocialMeli.model;

import com.sprint.SocialMeli.dto.in.PostDtoIn;
import com.sprint.SocialMeli.dto.in.PromoPostDtoIn;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

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

    public Post(PostDtoIn postDtoIn) throws ParseException {
        user_id = postDtoIn.getUser_id();
        id_post = postDtoIn.getId_post();
        date = parseToLocalDate(postDtoIn.getDate());
        product_id = postDtoIn.getDetail().getProduct_id();
        product_name = postDtoIn.getDetail().getProduct_name();
        type = postDtoIn.getDetail().getType();
        brand = postDtoIn.getDetail().getBrand();
        color = postDtoIn.getDetail().getColor();
        category = postDtoIn.getCategory();
        price = postDtoIn.getPrice();
        has_promo = false;
        discount = 0;
    }

    public Post(PromoPostDtoIn promoPostDtoIn) throws ParseException {
        user_id = promoPostDtoIn.getUser_id();
        id_post = promoPostDtoIn.getId_post();
        date = parseToLocalDate(promoPostDtoIn.getDate());
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

    private LocalDate parseToLocalDate(String stringDate) throws ParseException {
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(stringDate);
        return Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

}
