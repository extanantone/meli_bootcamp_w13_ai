package com.bootcamp.SocialMeli.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter


public class Post {
    private int userId;
    private int postId;
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;

    public Post(int userId, int postId, LocalDate date, Product detail, int category, double price) {
        this.userId = userId;
        this.postId = postId;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }
}
