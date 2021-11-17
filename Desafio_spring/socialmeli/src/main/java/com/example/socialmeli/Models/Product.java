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

}
