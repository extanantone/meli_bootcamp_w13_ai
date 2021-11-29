package com.Sprint1.SocialMeli.DTO;

import com.Sprint1.SocialMeli.Model.Product;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductDTO {
    @NotNull(message = "'productId' no puede estar vacía.")
    @Positive(message = "'productId' debe ser mayor a cero.")
    private Integer productId;

    @NotBlank(message = "'productName' no puede estar vacío.")
    @Size(max = 40, message = "La longitud de 'productName' no puede superar los 40 caracteres.")
    @Pattern(regexp = "[a-z|A-Z|á|é|í|ó|ú|ñ|Á|É|Í|Ó|Ú|Ñ|0-9| ]+", message = "'productName' no puede poseer caracteres especiales.")
    private String productName;

    @NotBlank(message = "'type' no puede estar vacío.")
    @Size(max = 15, message = "La longitud de 'type' no puede superar los 15 caracteres.")
    @Pattern(regexp = "[a-z|A-Z|á|é|í|ó|ú|ñ|Á|É|Í|Ó|Ú|Ñ|0-9]+", message = "'type' no puede poseer caracteres especiales ni espacios.")
    private String type;

    @NotBlank(message = "'brand' no puede estar vacío.")
    @Size(max = 25, message = "La longitud de 'brand' no puede superar los 25 caracteres.")
    @Pattern(regexp = "[a-z|A-Z|á|é|í|ó|ú|ñ|Á|É|Í|Ó|Ú|Ñ|0-9]+", message = "'brand' no puede poseer caracteres especiales ni espacios.")
    private String brand;

    @NotBlank(message = "'color' no puede estar vacío.")
    @Size(max = 15, message = "La longitud de 'color' no puede superar los 15 caracteres.")
    @Pattern(regexp = "[a-z|A-Z|á|é|í|ó|ú|ñ|Á|É|Í|Ó|Ú|Ñ|0-9]+", message = "'color' no puede poseer caracteres especiales ni espacios.")
    private String color;
    
    @Size(max = 80, message = "La longitud de 'notes' no puede superar los 80 caracteres.")
    @Pattern(regexp = "[a-z|A-Z|á|é|í|ó|ú|ñ|Á|É|Í|Ó|Ú|Ñ|0-9| ]+", message = "'notes' no puede poseer caracteres especiales.")
    private String notes;

    public ProductDTO (Product product){
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.type = product.getType();
        this.brand = product.getBrand();
        this.color = product.getColor();
        this.notes = product.getNotes();
    }
}
