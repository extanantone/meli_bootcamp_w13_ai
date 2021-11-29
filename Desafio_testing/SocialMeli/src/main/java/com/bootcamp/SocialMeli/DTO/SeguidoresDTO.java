package com.bootcamp.SocialMeli.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SeguidoresDTO {
    @NotNull(message = "La ID no puede estar vacía.")
    @Min(value=1,message = "El ID debe ser mayor a 0")
    private Integer userId;
    @Size(max=20,message = "La longitud no puede superar los 20 caracteres")
    @Pattern(regexp = "^[A-Z|À-Ù|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|à-ù|0-9|,|.| ]*$", message = "El campo no puede poseer caracteres especiales")
    private String userName;
    private List<UsuarioDTO> followers;
}
