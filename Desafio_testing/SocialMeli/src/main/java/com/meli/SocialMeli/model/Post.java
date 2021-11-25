package com.meli.SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Post {
    private int userId;
    private int idPost;
    private LocalDate date;
    private int category;
    private double price;
    private Product detail;
}
