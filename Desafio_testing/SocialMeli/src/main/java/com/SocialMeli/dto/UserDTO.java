package com.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDTO {
    @NotNull(message = "La id no puede estar vacía")
    @Positive(message = "El id debe ser mayor a cero")
    private Integer userId;

//    @NotBlank(message = "El campo no puede estar vacío.")
//    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
//    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "El campo no puede poseer caracteres especiales.")
    private String userName;
}
