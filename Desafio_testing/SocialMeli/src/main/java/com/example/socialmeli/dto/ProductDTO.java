package com.example.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Getter @Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProductDTO {

    @NotNull(message = "La id no puede estar vacía")
    @Positive (message = "El id debe ser mayor a cero")
    private Integer productId;

    @NotEmpty (message = "El campo no puede estar vacío")
    @Max( value = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern (regexp="^[A-Z|À-Ù|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|à-ù|0-9|,|.|\\s ]*$", message = "El campo no puede poseer caracteres especiales")
    private String productName;

    @NotEmpty (message = "El campo no puede estar vacío")
    @Max (value = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern (regexp="^[A-Z|À-Ù|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|à-ù|0-9|,|.|\\s ]*$", message = "El campo no puede poseer caracteres especiales")
    private String type;

    @NotEmpty (message = "El campo no puede estar vacío")
    @Max (value = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern (regexp="^[A-Z|À-Ù|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|à-ù|0-9|,|.|\\s ]*$", message = "El campo no puede poseer caracteres especiales")
    private String brand;

    @NotEmpty (message = "El campo no puede estar vacío")
    @Max (value = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern (regexp="^[A-Z|À-Ù|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|à-ù|0-9|,|.|\\s ]*$", message = "El campo no puede poseer caracteres especiales")
    private String color;

    @Max (value = 80, message = "La longitud no puede superar los 80 caracteres")
    @Pattern (regexp="^[A-Z|À-Ù|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|à-ù|0-9|,|.|\\s ]*$", message = "El campo no puede poseer caracteres especiales")
    private String notes;
}
