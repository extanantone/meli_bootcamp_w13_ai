package com.SprintI.SocialMeli.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Product {
    private int product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public Product(int product_id, String product_name, String type, String brand, String color, String notes) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + product_id +
                ", productName='" + product_name + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
