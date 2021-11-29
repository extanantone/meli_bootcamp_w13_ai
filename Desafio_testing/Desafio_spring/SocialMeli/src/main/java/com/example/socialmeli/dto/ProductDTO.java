package com.example.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)

public class ProductDTO {

    @NotNull(message = "La id no puede estar vacia")
    @Min(value = 1,message = "El id debe ser mayor a cero")
    private Integer productId;
    @NotEmpty(message = "El campo no puede estar vacio")
    @Size(max = 40,message = "La longitud no puede superar los 40 caracteres")
    @Pattern(regexp = "\\A[A-Z|À-Ù|\\u00f1|Á-Ú|Ä-Ü][A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü||á-ú|ä-ü|a-z|0-9]*(\\s[A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|0-9]*)*\\z",message = "El campo no puede poseer caracteres especiales.")
    private String productName;
    @NotEmpty(message = "El campo no puede estar vacio")
    @Size(max = 15,message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "\\A[A-Z|À-Ù|\\u00f1|Á-Ú|Ä-Ü][A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü|a-z|0-9]*[,|.]?(\\s[A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü|a-z|0-9]*[,|.]?)*\\z",message = "El campo no puede poseer caracteres especiales.")
    private String type;
    @NotEmpty(message = "El campo no puede estar vacio")
    @Size(max = 25,message = "La longitud no puede superar los 25 caracteres")
    @Pattern(regexp = "\\A[A-Z|À-Ù|\\u00f1|Á-Ú|Ä-Ü][A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü||á-ú|ä-ü|a-z|0-9]*(\\s[A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|0-9]*)*\\z",message = "El campo no puede poseer caracteres especiales.")
    private String brand;
    @NotEmpty(message = "El campo no puede estar vacio")
    @Size(max = 15,message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "\\A[A-Z|À-Ù|\\u00f1|Á-Ú|Ä-Ü][A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü||á-ú|ä-ü|a-z|0-9]*(\\s[A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|0-9]*)*\\z",message = "El campo no puede poseer caracteres especiales.")
    private String color;
    @Size(max = 80,message = "La longitud no puede superar los 80 caracteres")
    @Pattern(regexp = "\\A[A-Z|À-Ù|\\u00f1|Á-Ú|Ä-Ü][A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü||á-ú|ä-ü|a-z|0-9]*(\\s[A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|0-9]*)*\\z",message = "El campo no puede poseer caracteres especiales.")
    private String notes;
}
