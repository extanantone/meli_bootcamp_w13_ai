package com.example.socialmeli.dto;

import com.example.socialmeli.model.Product;

import java.time.LocalDate;

public class PostDto extends UserDto{
    private Integer post_id;
    private String category;
    private LocalDate date;
    private Boolean has_promo = false;
    private Double discount,price;
    private Product detail;

//    public PostDto(,Integer post_id, String category, LocalDate date, Boolean has_promo, Double discount, Double price, Product detail) {
//        this.post_id = post_id;
//        this.category = category;
//        this.date = date;
//        this.has_promo = has_promo;
//        this.discount = discount;
//        this.price = price;
//        this.detail = detail;
//        super.user_id = user_id;
//        super.user_name = user_name;
//    }
}
