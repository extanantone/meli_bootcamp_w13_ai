package com.socialMeli.socialMeli.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private int product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
