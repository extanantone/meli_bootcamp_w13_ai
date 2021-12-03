package com.bootcamp.SocialMeli.dto;

import com.bootcamp.SocialMeli.model.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
public class PostResponseDTO {
    private int postId;
    private LocalDate date;
    private Product detail;
    private int category;
    private double price;

}
