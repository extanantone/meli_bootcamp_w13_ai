package com.sprint.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
public class PostDto {
    int user_id;
    int id_post;
    String date;
    DetailPostDto detail;
    int category;
    double price;
    boolean has_promo;
    double discount;
}
