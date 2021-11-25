package com.bootcamp.SocialMeli.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Producto {
    private Integer productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public Producto(Integer productId, String productName, String type, String brand, String color, String notes) {
        this.productId = productId;
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }
}
