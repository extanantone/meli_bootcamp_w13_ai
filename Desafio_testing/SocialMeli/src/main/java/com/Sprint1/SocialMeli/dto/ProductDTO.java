package com.Sprint1.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ProductDTO {
    private int product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;

    @Override
    public String toString() {
        return "{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
