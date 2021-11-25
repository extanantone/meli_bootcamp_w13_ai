package com.socialMeli.SocialMeli.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetails {
    private Integer product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public ProductDetails(Integer product_id, String product_name, String type, String brand, String color, String notes) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }

}
