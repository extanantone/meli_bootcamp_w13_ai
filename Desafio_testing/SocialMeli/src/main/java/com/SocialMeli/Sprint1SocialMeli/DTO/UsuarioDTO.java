package com.SocialMeli.Sprint1SocialMeli.DTO;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    @NotNull(message = "La id no puede estar vacia")
    //@Min(value = 0, message = "El id debe ser mayor a 0")
    @Positive(message = "El id debe ser mayor a 0")
    private int userID;
    private String user_name;
}
