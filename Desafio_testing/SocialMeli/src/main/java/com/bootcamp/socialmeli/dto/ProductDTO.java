package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProductDTO {
    @NotNull(message = "La id no puede estar vacía")
    @Positive(message = "El id debe ser mayor a cero")
    private Integer productId;
    @NotNull(message = "El campo no puede estar vacio")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres")
    @Pattern(regexp = "[0-9|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú| ]*$", message = "El campo no puede poseer caracteres especiales")
    private String productName;
    @NotNull(message = "El campo no puede estar vacio")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "[0-9|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú| ]*$", message = "El campo no puede poseer caracteres especiales")
    private String type;
    @NotNull(message = "El campo no puede estar vacio")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres")
    @Pattern(regexp = "[0-9|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú| ]*$", message = "El campo no puede poseer caracteres especiales")
    private String brand;
    @NotNull(message = "El campo no puede estar vacio")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    @Pattern(regexp = "[0-9|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú| ]*$", message = "El campo no puede poseer caracteres especiales")
    private String color;
    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres")
    @Pattern(regexp = "[0-9|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú| ]*$", message = "El campo no puede poseer caracteres especiales")
    private String notes;
}

