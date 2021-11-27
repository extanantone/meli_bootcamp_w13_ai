package com.socialmeli.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    int product_id;
    String product_name;
    String type;
    String brand;
    String color;
    String notes;
}
