package com.example.socialmeli.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Post {

    private Integer userId;
    private Integer idPost;
    private Date date;
    private Product detail;
    private int category;
    private double price;
    private boolean hasPromo = false;
    private double discount = 0.0;
}
