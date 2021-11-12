package com.bootcamp.SocialMeli.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Producto {
    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
    private String category;

    public Producto(int productId, String productName, String type, String brand, String color, String notes, String category) {
        this.productId = productId;
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
        this.category = category;
    }
}
