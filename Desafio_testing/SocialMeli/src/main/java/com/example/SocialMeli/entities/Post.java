package com.example.SocialMeli.entities;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Long id;
    private Integer userId;
    private LocalDate date;
    private Detail detail;
    private int category;
    private double price;
}
