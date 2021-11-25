package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @NotNull(message = "La id del producto no puede estar vacía")
    @Positive(message = "La id del producto no puede ser negativa")
    @JsonProperty("product_id")
    private Long productId;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9áéíóúÁÉÍÓÚ&\\s]+|^$", message = "El campo no puede poseer caracteres especiales.")
    @JsonProperty("product_name")
    private String productName;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9áéíóúÁÉÍÓÚ&\\s]+|^$", message = "El campo no puede poseer caracteres especiales.")
    private String type;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9áéíóúÁÉÍÓÚ&\\s]+|^$", message = "El campo no puede poseer caracteres especiales.")
    private String brand;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9áéíóúÁÉÍÓÚ&\\s]+|^$", message = "El campo no puede poseer caracteres especiales.")
    private String color;
    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9áéíóúÁÉÍÓÚ\\s&%.,+]+|^$", message = "El campo no puede poseer caracteres especiales.")
    private String notes;
}
