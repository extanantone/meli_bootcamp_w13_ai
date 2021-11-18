package com.bootcamp.SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    int user_id;
    int is_post;
    LocalDate date;
    int product_id;
    String product_name,type,brand;



}
