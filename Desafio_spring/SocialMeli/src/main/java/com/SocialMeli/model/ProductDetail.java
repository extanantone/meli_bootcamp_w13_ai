package com.SocialMeli.model;

import com.SocialMeli.dto.ProductDetailDTO;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductDetail {

    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public ProductDetail(ProductDetailDTO detailDTO) {
        this.productId = detailDTO.getProductId();
        this.productName = detailDTO.getProductName();
        this.type = detailDTO.getType();
        this.brand = detailDTO.getBrand();
        this.color = detailDTO.getColor();
        this.notes = detailDTO.getNotes();
    }
}