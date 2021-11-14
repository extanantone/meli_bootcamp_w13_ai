package com.bootcamp.socialmeli.entitiy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    private int postId;
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;

}


