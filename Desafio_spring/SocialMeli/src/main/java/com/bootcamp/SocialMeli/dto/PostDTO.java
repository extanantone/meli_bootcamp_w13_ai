package com.bootcamp.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class PostDTO {
    private int userId;
    private int id_post;
    private String date;
    private ProductDTO detail;
    private int category;
    private double price;
}
