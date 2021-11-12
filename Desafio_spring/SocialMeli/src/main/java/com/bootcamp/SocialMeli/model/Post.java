package com.bootcamp.SocialMeli.model;

import java.time.LocalDate;

public class Post {
    private int idPost;
    private LocalDate date;
    private double price;
    private Producto producto;

    public Post(int idPost, LocalDate date, double price, Producto producto) {
        this.idPost = idPost;
        this.date = date;
        this.price = price;
        this.producto = producto;
    }
}
