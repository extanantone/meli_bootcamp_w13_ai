package com.example.socialmeli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
    private Integer category;
    private Double price;
    private boolean hasPromo = false;
    private Double discount = 0.0;
}
