package com.meli.SocialMeli.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Valid
public class UserDTO implements Serializable {
    @NotNull(message = "La ID del Usuario es obligatoria y no puede ser vacía.")
    @Positive(message = "La ID del Usuario debe ser mayor que cero.")
    private Integer userId;

    @NotEmpty(message = "El nombre del usuario es obligatorio y no puede ser vacío.")
    @Size(max = 15, message = "La longitud del nombre del usuario no puede superar los 15 caracteres.")
    @Pattern(regexp="\\A([A-Z]|[a-z]|[0-9]|ñ|Ñ|Á|É|Í|Ó|Ú|á|é|í|ó|ú|)*$", message = "El nombre del usuario debe comenzar con mayúscula.")
    private String userName;
}
