package com.bootcamp.SocialMeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDetail {
    private int id;
    private String name;
    private String brand;
    private String type;
    private String color;
    private String notes;
}
