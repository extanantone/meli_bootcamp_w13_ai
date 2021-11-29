package com.bootcamp.SocialMeli.dto;

import lombok.*;

import javax.validation.constraints.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

    @NotNull(message = "La id no puede estar vacia")
    @Positive(message = "El id debe ser mayor a 0")
    private Integer user_id;
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres")
    private String user_name;
}
