package com.example.socialmeli.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class Product {
    private static Integer productIdCount = 1;
    private Integer productId;
    private String productName,type,brand,color,notes;

    public Product(Integer productId, String productName, String type, String brand, String color, String notes) {
        this.productId = productIdCount;
        productIdCount++;
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }
}
