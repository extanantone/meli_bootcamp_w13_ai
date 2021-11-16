package com.bootcamp.SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publication {
    private Integer user_id;
    private Integer id_post;
    private LocalDate date;
    private Integer id_product;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
    private Integer category;
    private Double price;
}
