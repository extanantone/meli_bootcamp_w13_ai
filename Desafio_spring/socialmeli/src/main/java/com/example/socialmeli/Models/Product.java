package com.example.socialmeli.Models;

import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class Product {
    Integer user_id;
    Integer id_post;
    LocalDate date;
    DetalleProduct detail;
    Integer category;
    double price;

}
