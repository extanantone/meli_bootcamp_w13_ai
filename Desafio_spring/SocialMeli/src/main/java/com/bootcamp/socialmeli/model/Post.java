package com.bootcamp.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Post {

    private long id;
    private LocalDate date;
    private int category;
    private double price;

    private long userId;
    private long productId;

    public Post(LocalDate date, int category, double price, long userId, long productId) {
        this.date = date;
        this.category = category;
        this.price = price;
        this.userId = userId;
        this.productId = productId;
    }
}
