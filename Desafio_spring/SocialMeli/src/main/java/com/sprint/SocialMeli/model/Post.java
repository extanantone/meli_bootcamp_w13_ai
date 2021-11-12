package com.sprint.SocialMeli.model;

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

}
