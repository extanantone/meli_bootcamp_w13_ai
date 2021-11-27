package com.meli.SocialMeli.model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    private int userId;
    private int idPost;
    private LocalDate date;
    private int category;
    private double price;
    private Product detail;
}
