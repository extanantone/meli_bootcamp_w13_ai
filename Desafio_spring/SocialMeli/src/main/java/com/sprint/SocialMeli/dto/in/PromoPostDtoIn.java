package com.sprint.SocialMeli.dto.in;

import com.sprint.SocialMeli.dto.DetailPostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Getter
public class PromoPostDtoIn {
    int user_id;
    int id_post;
    String date;
    DetailPostDto detail;
    int category;
    double price;
    boolean has_promo;
    double discount;
}
