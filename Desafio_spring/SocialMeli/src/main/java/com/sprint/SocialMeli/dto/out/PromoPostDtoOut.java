package com.sprint.SocialMeli.dto.out;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sprint.SocialMeli.dto.DetailPostDto;
import com.sprint.SocialMeli.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter
public class PromoPostDtoOut {
    int id_post;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    LocalDate date;
    DetailPostDto detail;
    int category;
    double price;
    boolean has_promo;
    double discount;

    // Constructor personalizado para facilitar el parseo entre el modelo del dominio y el DTO
    public PromoPostDtoOut(Post post){
        id_post = post.getId_post();
        date = post.getDate();
        detail = new DetailPostDto(post.getProduct_id(), post.getProduct_name(), post.getType(), post.getBrand(), post.getColor(), post.getNotes());
        category = post.getCategory();
        price = post.getPrice();
        has_promo = post.isHas_promo();
        discount = post.getDiscount();
    }
}
