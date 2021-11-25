package com.meli.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    @NotNull(message = "La ID es obligatoria y no puede ser vacía.")
    @Positive(message = "La ID debe ser mayor que cero.")
    private Integer productId;

    @NotEmpty(message = "product_name es obligatorio y no puede ser vacío.")
    @Size(max = 40, message = "La longitud de product_name no puede superar los 40 caracteres.")
    @Pattern(regexp="\\A([A-Z]|[a-z]|[0-9]|ñ|Ñ|Á|É|Í|Ó|Ú|á|é|í|ó|ú|\\s)*$", message = "product_nameno debe contener caracteres especiales.")
    private String productName;

    @NotEmpty(message = "type es obligatorio y no puede ser vacío.")
    @Size(max = 15, message = "La longitud de type no puede superar los 15 caracteres.")
    @Pattern(regexp="\\A([A-Z]|[a-z]|[0-9]|ñ|Ñ|Á|É|Í|Ó|Ú|á|é|í|ó|ú)*$", message = "type no puede contener caracteres especiales ni espacios.")
    private String type;

    @NotEmpty(message = "brand es obligatorio y no puede ser vacío.")
    @Size(max = 15, message = "La longitud de brand no puede superar los 15 caracteres.")
    @Pattern(regexp="\\A([A-Z]|[a-z]|[0-9]|ñ|Ñ|Á|É|Í|Ó|Ú|á|é|í|ó|ú)*$", message = "brand no puede contener caracteres especiales ni espacios.")
    private String brand;

    @NotEmpty(message = "color es obligatorio y no puede ser vacío.")
    @Size(max = 15, message = "La longitud de color no puede superar los 15 caracteres.")
    @Pattern(regexp="\\A([A-Z]|[a-z]|[0-9]|ñ|Ñ|Á|É|Í|Ó|Ú|á|é|í|ó|ú)*$", message = "color no puede contener caracteres especiales ni espacios.")
    private String color;

    @Pattern(regexp="\\A([A-Z]|[a-z]|[0-9]|ñ|Ñ|Á|É|Í|Ó|Ú|á|é|í|ó|ú|\\s)*$", message = "notes no puede contener caracteres especiales.")
    @Size(max = 80, message = "La longitud de notes no puede superar los 80 caracteres.")
    private String notes;
}
