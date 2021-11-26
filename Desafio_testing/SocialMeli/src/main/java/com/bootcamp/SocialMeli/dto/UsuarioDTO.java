package com.bootcamp.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UsuarioDTO {
    @Positive(message = "El user_id debe ser mayor a cero.")
    @NotNull(message = "El user_id no puede estar vacío.")
    private Integer userId;

    @NotBlank(message = "El campo user_name no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "[A-Za-z0-9 ]*", message = "El campo user_name no puede poseer caracteres especiales.")
    private String userName;
}
