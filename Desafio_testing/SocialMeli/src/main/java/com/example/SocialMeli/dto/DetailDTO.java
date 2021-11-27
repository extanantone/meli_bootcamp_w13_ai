package com.example.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetailDTO {
    @NotNull(message = "La id no puede estar vacía.")
    @Positive(message = "El id debe ser mayor a cero")
    @JsonProperty("product_id")
    private Long id;

    @JsonProperty("product_name")
    @Pattern(regexp = "([A-Za-z0-9]| )+", message = "El campo no puede poseer caracteres especiales.")
    @NotNull(message = "El campo no puede estar vacío.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    private String productName;

    @NotNull(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "([A-Za-z0-9])+", message = "El campo no puede poseer caracteres especiales.")
    private String type;

    @NotNull(message = "El campo no puede estar vacío.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "([A-Za-z0-9])+", message = "El campo no puede poseer caracteres especiales.")
    private String brand;

    @NotNull(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "([A-Za-z0-9])+", message = "El campo no puede poseer caracteres especiales.")
    private String color;

    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "([A-Za-z0-9]| )+", message = "El campo no puede poseer caracteres especiales.")
    private String notes;
}