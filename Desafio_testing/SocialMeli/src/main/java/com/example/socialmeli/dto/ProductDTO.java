package com.example.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
@EqualsAndHashCode
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProductDTO {

    @NotEmpty(message = "La id no puede estar vacía")
    @Positive(message = "La id debe mayor a cero")
    private Integer productId;


    @NotEmpty(message = "El campo no puede estar vacío")
    @Max(value = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp="^[a-zA-Z0-9äöüÄÖÜ ]*$", message = "El campo no puede poseer caracteres especiales")
    private String productName;

    @NotEmpty(message = "El campo no puede estar vacío")
    @Max(value = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp="^[a-zA-Z0-9äöüÄÖÜ]*$", message = "El campo no puede poseer caracteres especiales")
    private String type;

    @NotEmpty(message = "El campo no puede estar vacío")
    @Max(value = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp="^[a-zA-Z0-9äöüÄÖÜ]*$", message = "El campo no puede poseer caracteres especiales")
    private String brand;

    @NotEmpty(message = "El campo no puede estar vacío")
    @Max(value = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp="^[a-zA-Z0-9äöüÄÖÜ]*$", message = "El campo no puede poseer caracteres especiales")
    private String color;

    @Max(value = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp="^[a-zA-Z0-9äöüÄÖÜ ]*$", message = "El campo no puede poseer caracteres especiales")
    private String notes;
}
