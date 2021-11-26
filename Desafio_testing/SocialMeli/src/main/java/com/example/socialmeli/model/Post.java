package com.example.socialmeli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
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
