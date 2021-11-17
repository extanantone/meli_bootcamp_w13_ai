package com.SprintI.SocialMeli.dtos;

import com.SprintI.SocialMeli.models.Product;

public class ProductDTO {
    private int product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public ProductDTO(Product product) {
        this.product_id = product.getProduct_id();
        this.product_name = product.getProduct_name();
        this.type = product.getType();
        this.brand = product.getBrand();
        this.color = product.getColor();
        this.notes = product.getNotes();
    }
}
