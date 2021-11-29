package com.SocialMeli.SocialMeli.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class UserDTO {
    @NotNull(message = "El campo no puede estar vacio")
    @Positive(message = "El id debe ser numerico")
    private Integer user_id;

    @NotBlank(message = "El campo no puede estar vacio")
    @Pattern(regexp = "^[a-zA-Z0-9]$", message = "El nombre no puede contener caracteres especiales")
    @Size(max=15, message = "La longitud no puede superar los 15 caracteres")
    private String user_name;
}
