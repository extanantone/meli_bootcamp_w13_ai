package com.Sprint1.SocialMeli.model;


import com.Sprint1.SocialMeli.dto.FollowerDTO;
import com.Sprint1.SocialMeli.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

@Getter  @Setter @NoArgsConstructor @AllArgsConstructor

public class Post {
    private int user_id;
    private int id_post;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO detail;
    private int category;
    private double price;

    @Override
    public String toString() {
        return "Post{" +
                "user_id=" + user_id +
                ", id_post=" + id_post +
                ", date=" + date +
                ", detail=" + detail +
                ", category=" + category +
                ", price=" + price +
                '}';
    }
}
