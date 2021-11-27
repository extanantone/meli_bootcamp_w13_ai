package com.socialmeli.socialmeli.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class UserFollowerCountDTO {
    @Min(value=0, message = "El id de usuario debe ser mayor a cero")
    int user_id;
    @NotBlank(message = "El campo no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El campo no puede poseer caracteres especiales.")
    @Size(max = 10, message = "La longitud no puede superar los 15 caracteres.")
    String user_name;
    int followers_count;
}
