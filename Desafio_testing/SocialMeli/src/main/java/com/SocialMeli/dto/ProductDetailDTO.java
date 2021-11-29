package com.SocialMeli.dto;

import com.SocialMeli.model.ProductDetail;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductDetailDTO {

    @NotNull(message = "La id no puede estar vacía.")
    @Positive(message = "La id debe ser mayor a cero")
    private Integer productId;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "^[0-9a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[0-9a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[0-9a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$", message = "El campo no puede poseer caracteres especiales.")
    private String productName;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^([0-9a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)+$", message = "El campo no puede poseer caracteres especiales.")
    private String type;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "^([0-9a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)+$", message = "El campo no puede poseer caracteres especiales.")
    private String brand;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^([0-9a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)+$", message = "El campo no puede poseer caracteres especiales.")
    private String color;

    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "^[0-9a-zA-ZÀ-ÿ\\u00f1\\u00d1]+(\\s*[0-9a-zA-ZÀ-ÿ\\u00f1\\u00d1]*)*[0-9a-zA-ZÀ-ÿ\\u00f1\\u00d1]+$", message = "El campo no puede poseer caracteres especiales.")
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
