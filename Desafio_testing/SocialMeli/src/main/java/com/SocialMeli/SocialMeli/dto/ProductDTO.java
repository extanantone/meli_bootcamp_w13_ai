package com.SocialMeli.SocialMeli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotNull(message = "El ID no puede estar vacío.")
    @Positive(message = "El ID debe ser mayor a cero.")
    private int product_id;

    @NotNull(message = "El campo product_name no puede estar vacío.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "[0-9|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú| ]*$", message = "El campo product_name no puede poseer caracteres especiales.")
    private String product_name;

    @NotNull(message = "El campo type no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "[0-9|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú| ]*$", message = "El campo type no puede poseer caracteres especiales.")
    private String type;

    @NotNull(message = "El campo brand no puede estar vacío.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "[0-9|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú| ]*$", message = "El campo brand no puede poseer caracteres especiales.")
    private String brand;

    @NotNull(message = "El campo color no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "[0-9|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú| ]*$", message = "El campo color no puede poseer caracteres especiales.")
    private String color;

    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "[0-9|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú| ]*$", message = "El campo notes no puede poseer caracteres especiales.")
    private String notes;
}