package com.example.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.*;

@Getter @Setter @Data @AllArgsConstructor @NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProductDTO {

    @Positive(message = "El id debe ser mayor a cero.")
    @NotNull(message = "El id no puede estar vacía.")
    private Integer productId;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 40,message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "([A-Z]|[0-9])[[0-9]|A-Z|a-z|ñ|á|é|í|ó|ú|Á|É|Í|Ó|Ú|.| ]*$",message = "El campo no puede poseer caracteres especiales.")
    private String productName;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15,message = "La longitud no puede superar los 15 caracteres.")
    @Pattern (regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|á|é|í|ó|ú|Á|É|Í|Ó|Ú| ]*$",message = "El campo no puede poseer caracteres especiales.")
    private String type;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 25,message = "La longitud no puede superar los 25 caracteres.")
    @Pattern (regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|á|é|í|ó|ú|Á|É|Í|Ó|Ú| ]*$",message = "El campo no puede poseer caracteres especiales.")
    private String brand;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15,message = "La longitud no puede superar los 15 caracteres.")
    @Pattern (regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|á|é|í|ó|ú|Á|É|Í|Ó|Ú| ]*$",message = "El campo no puede poseer caracteres especiales.")
    private String color;

    @Size(max = 80,message = "La longitud no puede superar los 80 caracteres.")
    @Pattern (regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|á|é|í|ó|ú|Á|É|Í|Ó|Ú|@|.| ]*$")
    private String notes;
}
