package com.Sprint1.SocialMeli.Model;

import com.Sprint1.SocialMeli.DTO.ProductDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Product {
    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public Product (ProductDTO productDTO){
        this.productId = productDTO.getProductId();
        this.productName = productDTO.getProductName();
        this.type = productDTO.getType();
        this.brand = productDTO.getBrand();
        this.color = productDTO.getColor();
        this.notes = productDTO.getNotes();
    }
}
