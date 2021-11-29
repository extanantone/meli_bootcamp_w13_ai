package com.example.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ProductDto {

    @Positive(message = "El id debe ser mayor a cero")
    @NotNull(message = "El id debe ser mayor a cero")
    private int productId;

    @NotEmpty(message = "El campo no puede estar vacio")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "([A-Za-z0-9]| )+", message = "El campo no puede poseer caracteres especiales")
    private String productName;

    @NotEmpty(message = "El campo no puede estar vacio")
    @Size(max = 15, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "([A-Za-z0-9]| )+", message = "El campo no puede poseer caracteres especiales")
    private String type;

    @NotEmpty(message = "El campo no puede estar vacio")
    @Size(max = 25, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "([A-Za-z0-9]| )+", message = "El campo no puede poseer caracteres especiales")
    private String brand;

    @NotEmpty(message = "El campo no puede estar vacio")
    @Size(max = 15, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "([A-Za-z0-9]| )+", message = "El campo no puede poseer caracteres especiales")
    private String color;

    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "([A-Za-z0-9]| )+", message = "El campo no puede poseer caracteres especiales")
    private String notes;

}
