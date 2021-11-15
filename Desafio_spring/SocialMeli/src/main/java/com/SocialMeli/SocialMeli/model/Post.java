package com.SocialMeli.SocialMeli.model;

import com.SocialMeli.SocialMeli.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int user_id;
    private int id_post;
    private LocalDate date;
    private ProductDTO detail;
    private int category;
    private double price;
}