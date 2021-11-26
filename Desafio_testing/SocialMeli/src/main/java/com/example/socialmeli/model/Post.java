package com.example.socialmeli.model;

import java.time.LocalDate;

public class Post {
    private final Integer idPost;
    private final Integer userId;
    private final LocalDate date;
    private final PostDetail details;
    private final Integer category;
    private final Double price;

    public Post(Integer idPost, Integer userId, LocalDate date, PostDetail details, Integer category, Double price) {
        this.idPost = idPost;
        this.userId = userId;
        this.date = date;
        this.details = details;
        this.category = category;
        this.price = price;
    }

    public Integer getIdPost() { return idPost; }

    public Integer getUserId() { return userId; }

    public LocalDate getDate() { return date; }

    public PostDetail getDetails() { return details; }

    public Integer getCategory() { return category; }

    public Double getPrice() { return price; }
}
