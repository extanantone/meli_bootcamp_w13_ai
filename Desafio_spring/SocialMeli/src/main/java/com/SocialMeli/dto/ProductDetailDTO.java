package com.SocialMeli.dto;

import com.SocialMeli.model.ProductDetail;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductDetailDTO {

    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public ProductDetailDTO(ProductDetail productDetail) {
        this.productId = productDetail.getProductId();
        this.productName = productDetail.getProductName();
        this.type = productDetail.getType();
        this.brand = productDetail.getBrand();
        this.color = productDetail.getColor();
        this.notes = productDetail.getNotes();
    }
}
