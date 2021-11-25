package com.bootcamp.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DetalleProductoDTO {
    @NotNull(message = "El ID no puede estar vacío.")
    @Positive(message = "El ID debe ser mayor a cero.")
    private int productId;

    @NotBlank(message = "El campo product_name no puede estar vacío.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "El campo product_name no puede poseer caracteres especiales.")
    private String productName;

    @NotBlank(message = "El campo type no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "El campo type no puede poseer caracteres especiales.")
    private String type;

    @NotBlank(message = "El campo brand no puede estar vacío.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "El campo brand no puede poseer caracteres especiales.")
    private String brand;

    @NotBlank(message = "El campo color no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "El campo color no puede poseer caracteres especiales.")
    private String color;

    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    //TODO tildes? dieresis comas puntos
    @Pattern(regexp = "^[a-zA-Z0-9ñáéíóúüÁÉÍÓÚ,. ]+$", message = "El campo notes no puede poseer caracteres especiales.")
    private String notes;
}
