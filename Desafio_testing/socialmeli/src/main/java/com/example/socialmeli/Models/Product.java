package com.example.socialmeli.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    Integer user_id;
    Integer id_post;
    LocalDate date;
    DetalleProduct detail;
    Integer category;
    double price;
    Boolean has_promo;
    double discount;

    public Product(Integer user_id, Integer id_post, LocalDate date, DetalleProduct detail, Integer category, double price) {
        this.user_id = user_id;
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }
}
