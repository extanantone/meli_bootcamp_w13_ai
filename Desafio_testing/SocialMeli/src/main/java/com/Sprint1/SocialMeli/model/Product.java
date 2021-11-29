package com.Sprint1.SocialMeli.model;

import lombok.*;

@Data
@NoArgsConstructor @AllArgsConstructor

public class Product {
    private int product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
