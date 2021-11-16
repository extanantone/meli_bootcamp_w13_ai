package com.example.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter

public class Product {
    private static Integer product_id_count = 1;
    Integer product_id;
    private String product_name,type,brand,color,notes;

    public Product(Integer product_id, String product_name, String type, String brand, String color, String notes) {
        this.product_id = this.product_id_count;
        this.product_id_count++;
        this.product_name = product_name;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }
}
