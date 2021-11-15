package com.bootcamp.SocialMeli.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Publicacion {
    private int idPost;
    private LocalDate date;
    private Producto producto;
    private double price;
    private int category;


    public Publicacion(int idPost, LocalDate date, double price, Producto producto, int category) {
        this.idPost = idPost;
        this.date = date;
        this.price = price;
        this.producto = producto;
        this.category = category;
    }
}
