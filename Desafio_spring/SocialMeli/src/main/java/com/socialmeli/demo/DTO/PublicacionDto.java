package com.socialmeli.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublicacionDTO {
    private int user_id;
    private int id_post;
    private String date;
    private ProductoDTO detail;
    private int category;
    private double price;
    private boolean has_promo;
    private double discount;
}
