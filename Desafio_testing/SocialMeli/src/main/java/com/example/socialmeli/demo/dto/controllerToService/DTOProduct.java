package com.example.socialmeli.demo.dto.controllerToService;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DTOProduct {

    @NotNull(message = "La id no puede estar vacia.")
    @Positive(message = "El id debe ser mayor a 0.")
    private int productId;

    @NotNull(message = "El campo no puede estar vacio.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp="([A-Z]|[a-z]|[0-9]|ñ|á|é|í|ó|ú|Á|É|Í|Ó|Ú| |, )+", message = "El campo no puede poseer caracteres especiales.")
    private String productName;

   @NotNull(message = "El campo no puede estar vacio")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp="([A-Z]|[a-z]|[0-9])+", message = "El campo no puede poseer caracteres especiales.")
    private String type;

    @NotNull(message = "El campo no puede estar vacio")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp="([A-Z]|[a-z]|[0-9])+", message = "El campo no puede poseer caracteres especiales.")
    private String brand;

    @NotNull(message = "El campo no puede estar vacio")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp="([A-Z]|[a-z]|[0-9])+", message = "El campo no puede poseer caracteres especiales.")
    private String color;

   @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp="([A-Z]|[a-z]|[0-9]| )+", message = "El campo no puede poseer caracteres especiales.")
   @JsonInclude(JsonInclude.Include.NON_NULL)
    private String notes;


}
