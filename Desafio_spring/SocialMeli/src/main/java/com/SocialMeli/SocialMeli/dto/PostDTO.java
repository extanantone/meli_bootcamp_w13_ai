package com.SocialMeli.SocialMeli.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private int user_id;
    private int id_post;
    private String date;
    private ProductDTO detail;
    private int category;
    private double price;
}
