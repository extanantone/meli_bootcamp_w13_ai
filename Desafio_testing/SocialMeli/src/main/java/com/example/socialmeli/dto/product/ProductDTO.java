package com.example.socialmeli.dto.product;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductDTO
{
    @NotNull(message = "La id no puede estar vacía.")
    @Positive(message = "El id debe ser mayor a 0.")
    private Integer productId;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "\\A[\\w\\s]+\\z" , message = "El campo no puede poseer caracteres especiales.")
    private String productName;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "\\A\\w+\\z" , message = "El campo no puede poseer caracteres especiales.")
    private String type;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "\\A\\w+\\z" , message = "El campo no puede poseer caracteres especiales.")
    private String brand;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "\\A[\\w]+\\z" , message = "El campo no puede poseer caracteres especiales.")
    private String color;

    @Size(max = 80, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "\\A[\\w\\s]+\\z" , message = "El campo no puede poseer caracteres especiales.")
    private String notes;
}
