package com.example.socialmeli.model;

public class PostDetail {
    private final Integer productId;
    private final String productName;
    private final String type;
    private final String brand;
    private final String color;
    private final String notes;

    public PostDetail(Integer productId, String productName, String type, String brand, String color, String notes) {
        this.productId = productId;
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }

    public Integer getProductId() { return productId; }

    public String getProductName() { return productName; }

    public String getType() { return type; }

    public String getBrand() { return brand; }

    public String getColor() { return color; }

    public String getNotes() { return notes; }
}
