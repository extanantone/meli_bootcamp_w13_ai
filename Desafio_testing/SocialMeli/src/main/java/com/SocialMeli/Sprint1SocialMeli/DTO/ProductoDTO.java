package com.SocialMeli.Sprint1SocialMeli.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductoDTO {

    @Positive(message = "Solo valores positivos")
    @NotNull(message = "El ID no puede puede ser Null")
    private int productId;

    @NotBlank(message = "el nombre del producto no puede ser vacio")
    @Size(max = 40,message = "Tamaño maximo de 40 caracteres")
    @Pattern(regexp = "\\A[A-Z|À-Ù|\\u00f1|Á-Ú|Ä-Ü][A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü|" +
            "|á-ú|ä-ü|a-z|0-9]*[,|.]?(\\s[A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|" +
            "Ä-Ü|á-ú|ä-ü|a-z|0-9]*[,|.]?)*\\z",message = "El campo no puede poseer caracteres especiales.\n")
    private String productName;

    @NotBlank(message = "el tipo de producto no puede ser vacio")
    @Size(max = 15,message = "No puede contener mas de 15 caracteres")
    @Pattern(regexp = "^([a-z]|[A-Z]|[ñ]|[Ñ])+$",message = "El campo no puede poseer caracteres especiales.\n")
    private String type;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 25,message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "\\A[A-Z|À-Ù|\\u00f1|Á-Ú|Ä-Ü][A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü|" +
            "|á-ú|ä-ü|a-z|0-9]*[,|.]?(\\s[A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|" +
            "Ä-Ü|á-ú|ä-ü|a-z|0-9]*[,|.]?)*\\z",message = "El campo no puede poseer caracteres especiales.\n")
    private String brand;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15,message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "\\A[A-Z|À-Ù|\\u00f1|Á-Ú|Ä-Ü][A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü|" +
            "|á-ú|ä-ü|a-z|0-9]*[,|.]?(\\s[A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|" +
            "Ä-Ü|á-ú|ä-ü|a-z|0-9]*[,|.]?)*\\z",message = "El campo no puede poseer caracteres especiales.\n")
    private String color;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 80,message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "\\A[A-Z|À-Ù|\\u00f1|Á-Ú|Ä-Ü][A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|Ä-Ü|" +
            "|á-ú|ä-ü|a-z|0-9]*[,|.]?(\\s[A-Z|À-Ù|\\u00f1|\\u00d1|Á-Ú|" +
            "Ä-Ü|á-ú|ä-ü|a-z|0-9]*[,|.]?)*\\z",message = "El campo no puede poseer caracteres especiales.\n")
    private String notes;


}
