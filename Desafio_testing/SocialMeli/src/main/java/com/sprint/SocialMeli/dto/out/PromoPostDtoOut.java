package com.sprint.SocialMeli.dto.out;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sprint.SocialMeli.dto.DetailPostDto;
import com.sprint.SocialMeli.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
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
        id_post = post.getIdPost();
        date = post.getDate();
        detail = new DetailPostDto(post.getProductId(), post.getProductName(), post.getType(), post.getBrand(), post.getColor(), post.getNotes());
        category = post.getCategory();
        price = post.getPrice();
        has_promo = post.isHasPromo();
        discount = post.getDiscount();
    }
}
