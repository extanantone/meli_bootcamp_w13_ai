package com.example.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Post
{
    private int idPost;
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;
}
