package com.bootcamp.SocialMeli.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SeguidorDTO {
    @NotNull(message = "La ID no puede estar vacía.")
    @Min(value=1,message = "El ID debe ser mayor a 0")
    private Integer idUser;
    @Size(max=20,message = "La longitud no puede superar los 20 caracteres")
    @Pattern(regexp = "^[A-Z|À-Ù|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|à-ù|0-9|,|.| ]*$", message = "El campo no puede poseer caracteres especiales")
    private String userName;
    @NotNull(message = "La ID no puede estar vacía.")
    @Min(value=1,message = "El ID debe ser mayor a 0")
    private Integer idUserFollow;
    @Size(max=20,message = "La longitud no puede superar los 20 caracteres")
    @Pattern(regexp = "^[A-Z|À-Ù|Á-Ú|Ä-Ü|á-ú|ä-ü|a-z|à-ù|0-9|,|.| ]*$", message = "El campo no puede poseer caracteres especiales")
    private String nameFollowed;

    public SeguidorDTO(String userName, Integer idUser, String nameFollowed, Integer idUserFollow) {
        this.userName=userName;
        this.idUser=idUser;
        this.idUserFollow=idUserFollow;
        this.nameFollowed=nameFollowed;
    }
}
