package com.bootcamp.SocialMeli.entity;

import com.bootcamp.SocialMeli.dto.PostDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Post {

    User user;
    int idPost;
    Product detail;
    LocalDate date;
    int category;
    double price;
    boolean hasPromo;
    double discount;



}
