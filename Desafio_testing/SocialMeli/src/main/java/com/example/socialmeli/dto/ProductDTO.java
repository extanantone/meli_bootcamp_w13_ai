package com.example.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter @Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProductDTO {

    @NotNull(message = "La id no puede estar vacía. ")
    @Positive(message = "El id debe ser mayor a cero. ")
    private Integer productId;

    @NotNull(message = "La id no puede estar vacía. ")
    @Size(min =0,message = "El id debe ser mayor a cero. ")
    @Pattern(regexp = "[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+",message = "La longitud no puede superar los 40 caracteres. ")
    private String productName;

    @NotNull(message = "La id no puede estar vacía. ")
    @Size(min =0,max = 15,message = "La longitud no puede superar los 15 caracteres. ")
    @Pattern(regexp = "[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+",message = "El campo no puede poseer caracteres especiales. ")
    private String type;

    @NotNull(message = "La id no puede estar vacía. ")
    @Size(min =0,max = 25,message = "La longitud no puede superar los 25 caracteres. ")
    @Pattern(regexp = "[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+",message = "El campo no puede poseer caracteres especiales. ")
    private String brand;

    @NotNull(message = "La id no puede estar vacía. ")
    @Size(min =0,max = 15,message = "La longitud no puede superar los 15 caracteres. ")
    @Pattern(regexp = "[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+",message = "El campo no puede poseer caracteres especiales. ")
    private String color;

    @Size(min =0,max = 80,message = "La longitud no puede superar los 80 caracteres. ")
    @Pattern(regexp = "[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+",message = "El campo no puede poseer caracteres especiales. ")
    private String notes;

}
