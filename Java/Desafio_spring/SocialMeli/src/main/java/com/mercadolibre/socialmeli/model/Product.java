package com.mercadolibre.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;

}
