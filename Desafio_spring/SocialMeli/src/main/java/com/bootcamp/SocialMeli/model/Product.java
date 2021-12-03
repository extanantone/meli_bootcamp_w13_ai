package com.bootcamp.SocialMeli.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Product {
    private int productId;
    private String productName, type, brand, color, notes;

    public Product(int productId, String productName, String type, String brand, String color, String notes) {
        this.productId = productId;
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }
}
