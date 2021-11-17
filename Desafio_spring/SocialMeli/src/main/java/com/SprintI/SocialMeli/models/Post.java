package com.SprintI.SocialMeli.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class Post {
    private int idPost;
    private int userId;

    private LocalDate date;

    private Product detail;

    private int category;
    private double price;

    private boolean hasPromo;
    private double discount;

    public Post(int idPost, int userId, LocalDate date, Product detail, int category, double price) {
        this.idPost = idPost;
        this.userId = userId;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public Post(int idPost, int userId, LocalDate date, Product detail, int category, double price, boolean hasPromo, double discount) {
        this.idPost = idPost;
        this.userId = userId;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Post{" +
                "idPost=" + idPost +
                ", userId=" + userId +
                ", date=" + date +
                ", detail=" + detail +
                ", category=" + category +
                ", price=" + price +
                ", hasPromo=" + hasPromo +
                ", discount=" + discount +
                '}';
    }
}

