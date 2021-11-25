package com.Sprint1.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PostDTO {
    private int user_id;
    private int id_post;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO detail;
    private int category;
    private double price;

    @Override
    public String toString() {
        return "{" +
                "user_id=" + user_id +
                ", id_post=" + id_post +
                ", date=" + date +
                ", detail=" + detail +
                ", category=" + category +
                ", price=" + price +
                '}';
    }


}
