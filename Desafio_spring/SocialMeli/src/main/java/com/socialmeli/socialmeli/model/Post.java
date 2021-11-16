package com.socialmeli.socialmeli.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Post {
    int user_id;
    int id_post;
    LocalDate date;
    Product detail;
    int category;
    double price;
    boolean has_promo;
    double discount;

}
