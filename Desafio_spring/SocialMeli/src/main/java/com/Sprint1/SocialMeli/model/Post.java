package com.Sprint1.SocialMeli.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter  @Setter @NoArgsConstructor @AllArgsConstructor

public class Post {
    private int user_id;
    private int id_post;
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;

}
