package com.bootcamp.SocialMeli.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DetallePublicacionDTO {
    @NotNull(message = "La ID no puede estar vacía.")
    @Min(value=1,message = "El ID debe ser mayor a 0")
    private Integer productId;
    @NotBlank(message = "El campo productName no puede estar vacío.")
    @Size(max=40,message = "La longitud de productName no puede superar los 40 caracteres")
    @Pattern(regexp = "^[A-Z|À-Ù|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|à-ù|0-9|,|.| ]*$", message = "El campo productName no puede poseer caracteres especiales")
    private String productName;
    @NotBlank(message = "El campo type no puede estar vacío.")
    @Size(max=15,message = "La longitud de type no puede superar los 15 caracteres")
    @Pattern(regexp = "^[A-Z|À-Ù|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|à-ù|0-9|,|.| ]*$", message = "El campo type no puede poseer caracteres especiales")
    private String type;
    @NotBlank(message = "El campo brand no puede estar vacío.")
    @Size(max=25,message = "La longitud de brand no puede superar los 25 caracteres")
    @Pattern(regexp = "^[A-Z|À-Ù|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|à-ù|0-9|,|.| ]*$", message = "El campo brand no puede poseer caracteres especiales")
    private String brand;
    @NotBlank(message = "El campo color no puede estar vacío.")
    @Size(max=15,message = "La longitud de color no puede superar los 15 caracteres")
    @Pattern(regexp = "^[A-Z|À-Ù|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|à-ù|0-9|,|.| ]*$", message = "El campo color no puede poseer caracteres especiales")
    private String color;
    @Size(max=80,message = "La longitud de notes no puede superar los 80 caracteres")
    @Pattern(regexp = "^[A-Z|À-Ù|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|à-ù|0-9|,|.| ]*$", message = "El campo notes no puede poseer caracteres especiales")
    private String notes;
}
