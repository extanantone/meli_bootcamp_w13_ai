package com.sprint.SocialMeli.dto;

import com.sprint.SocialMeli.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Getter
public class PostDtoOut {
    int id_post;
    String date;
    DetailPostDto detail;
    int category;
    double price;

    public PostDtoOut(Post post){
        id_post = post.getId_post();
        date = post.getDate().toString();
        detail = new DetailPostDto(post.getProduct_id(), post.getProduct_name(), post.getType(), post.getBrand(), post.getColor(), post.getNotes());
        category = post.getCategory();
        price = post.getPrice();
    }
}
