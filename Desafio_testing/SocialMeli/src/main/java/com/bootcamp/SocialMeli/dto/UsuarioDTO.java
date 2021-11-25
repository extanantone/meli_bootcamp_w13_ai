package com.bootcamp.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UsuarioDTO {
    @Positive(message = "El ID del usuario debe ser mayor a cero.")
    @NotNull(message = "El ID del usuario no puede estar vacío.")
    private Integer userId;

    @NotBlank(message = "El campo user_name no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "[A-Za-z0-9]+", message = "El campo user_name no puede poseer caracteres especiales.")
    private String userName;
}
