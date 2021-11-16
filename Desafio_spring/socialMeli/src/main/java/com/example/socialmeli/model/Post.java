package com.example.socialmeli.model;

import com.example.socialmeli.exception.BadBodyRequestException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter

public class Post {
    private static Integer post_id_count = 1;
    private Integer post_id,user_id;
    private String category;
    private LocalDate date;
    private Boolean has_promo = false;
    private Double discount,price;
    private Product detail;

    public Post(Integer user_id, String date, String category, Boolean has_promo, Double discount, Double price, Product detail) {
        try {
            this.user_id = user_id;
            this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            this.category = category;
            this.has_promo = has_promo;
            this.discount = discount;
            this.price = price;
            this.detail = detail;
            this.post_id = post_id_count;
            post_id_count++;

        }catch (DateTimeException e){
            System.out.print(e);
            throw new BadBodyRequestException("El formato de la fecha no es correcto");
        }

    }

    public void setHas_promo(Boolean has_promo) {
        this.has_promo = has_promo;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
