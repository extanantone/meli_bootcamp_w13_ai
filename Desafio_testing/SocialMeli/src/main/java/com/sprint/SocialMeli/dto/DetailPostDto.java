package com.sprint.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@AllArgsConstructor @NoArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Validated
@Data
public class DetailPostDto {
    @NotNull(message = "La id no puede estar vacía.")
    // Lo que sea numérico no sería necesario agregar una validación aparte
    @Positive(message = "El id debe ser mayor a cero")
    Integer productId;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(min = 0, max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "[A-Z|a-z|ñ|ó|í|á|é|ú|Ñ|Á|Ó|É|Í|Ú| ]+", message = "El campo no puede poseer caracteres especiales.")
    String productName;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(min = 0, max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "[A-Z|a-z|ñ|ó|í|á|é|ú|Ñ|Á|Ó|É|Í|Ú| ]+", message = "El campo no puede poseer caracteres especiales.")
    String type;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(min = 0, max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "[A-Z|a-z|ñ|ó|í|á|é|ú|Ñ|Á|Ó|É|Í|Ú| ]+", message = "El campo no puede poseer caracteres especiales.")
    String brand;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(min = 0, max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "[A-Z|a-z|ñ|ó|í|á|é|ú|Ñ|Á|Ó|É|Í|Ú| ]+", message = "El campo no puede poseer caracteres especiales.")
    String color;
    @Size(min = 0, max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "[A-Z|a-z|ñ|ó|í|á|é|ú|Ñ|Á|Ó|É|Í|Ú| ]+", message = "El campo no puede poseer caracteres especiales.")
    String notes;
}
