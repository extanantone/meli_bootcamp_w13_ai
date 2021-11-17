package com.bootcamp.SocialMeli.model;

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
    private int id;
    private int userId;
    private LocalDate date;
    private ProductDetail productDetail;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;
}
