package com.example.socialmeli.dto;

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
public class ProductDto {

    @NotNull(message = "La id del producto no puede estar vacia")
    @Positive(message = "El id del producto debe ser mayor a cero")
    private Integer productId;

    @NotNull(message = "El nombre del producto no puede estar vacio")
    @Size(min=1,max=40,message = "La longitud del nombre del producto no puede superar los 40 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9_ ]{1,40}$",message = "El nombre del producto no puede poseer caracteres especiales")
    private String productName;

    @NotNull(message = "El tipo no puede estar vacio")
    @Size(min=1,max=15,message = "La longitud del tipo no puede superar los 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9]{1,15}$",message = "El tipo no puede poseer caracteres especiales")
    private String type;

    @NotNull(message = "El brand no puede estar vacio")
    @Size(min=1,max=25,message = "La longitud del brand no puede superar los 25 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9]{1,25}$",message = "El brand no puede poseer caracteres especiales")
    private String brand;

    @NotNull(message = "El color no puede estar vacio")
    @Size(min=1,max=15,message = "La longitud del color no puede superar los 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9]{1,15}$",message = "El color no puede poseer caracteres especiales")
    private String color;

    @Size(min=1,max=80,message = "La longitud de las notas no puede superar los 80 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9_ ]{0,80}$",message = "Las notas no puede poseer caracteres especiales")
    private String notes;

}
