package com.sprint.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@AllArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Validated
@Data
@NoArgsConstructor
// No se usa nunca de entrada pero bueno agrego igual como sería la validación del userName
public class UserDto {
    @NotNull(message = "El id no puede estar vacío")
    @Positive(message = "El id debe ser mayor a cero")
    Integer userId;
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(min = 0, max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "[A-Z|a-z|ñ|ó|í|á|é|ú|Ñ|Á|Ó|É|Í|Ú]+", message = "El campo no puede poseer caracteres especiales.")
    String userName;
}
