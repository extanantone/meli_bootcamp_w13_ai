package com.example.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductDetailDTO {

    @NotNull(message = "La id no puede estar vacía.")
    @Min(value = 1, message = "El id debe ser mayor a cero.")
    private final Integer productId;

    @NotNull(message = "El campo no puede estar vacío.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "El campo no puede poseer caracteres especiales.")
    private final String productName;

    @NotNull(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "El campo no puede poseer caracteres especiales.")
    private final String type;

    @NotNull(message = "El campo no puede estar vacío.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "El campo no puede poseer caracteres especiales.")
    private final String brand;

    @NotNull(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "El campo no puede poseer caracteres especiales.")
    private final String color;

    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "El campo no puede poseer caracteres especiales.")
    private final String notes;
}
