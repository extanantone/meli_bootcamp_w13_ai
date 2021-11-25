package com.example.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter @Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProductDTO {
    @Valid
    @NotNull(message = "El id no puede estar vacia.")
    @Min(value = 1, message = "El id debe ser mayor a 0")
    private Integer productId;
    @NotNull(message = "El campo no puede estar vacio")
    @Max(value = 40, message = "La longitud no puede superar los 40 caracteres")
    @Pattern(regexp ="\\A[A-Z|À-Ù|\\u00f1|Á-Ú|Ä-Ü][A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü||á-ú|ä-ü|a-z|0-9]*[,|.]?(\\s[A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|0-9]*[,|.]?)*\\z", message="El campo no puede poseer caracteres especiales.")
    private String productName;
    @NotNull(message = "El campo no puede estar vacio")
    @Max(value = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp ="\\A[A-Z|À-Ù|\\u00f1|Á-Ú|Ä-Ü][A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü||á-ú|ä-ü|a-z|0-9]*[,|.]?(\\s[A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|0-9]*[,|.]?)*\\z", message="El campo no puede poseer caracteres especiales.")
    private String type;

    @NotNull(message = "El campo no puede estar vacio")
    @Max(value = 25, message = "La longitud no puede superar los 25 caracteres")
    @Pattern(regexp ="\\A[A-Z|À-Ù|\\u00f1|Á-Ú|Ä-Ü][A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü||á-ú|ä-ü|a-z|0-9]*[,|.]?(\\s[A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|0-9]*[,|.]?)*\\z", message="El campo no puede poseer caracteres especiales.")
    private String brand;
    @NotNull(message = "El campo no puede estar vacio")
    @Max(value =15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp ="\\A[A-Z|À-Ù|\\u00f1|Á-Ú|Ä-Ü][A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü||á-ú|ä-ü|a-z|0-9]*[,|.]?(\\s[A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|0-9]*[,|.]?)*\\z", message="El campo no puede poseer caracteres especiales.")
    private String color;
    @NotNull(message = "El campo no puede estar vacio")
    @Max(value =80, message = "La longitud no puede superar los 80 caracteres")
    @Pattern(regexp ="\\A[A-Z|À-Ù|\\u00f1|Á-Ú|Ä-Ü][A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü||á-ú|ä-ü|a-z|0-9]*[,|.]?(\\s[A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|0-9]*[,|.]?)*\\z", message="El campo no puede poseer caracteres especiales.")
    private String notes;
}
