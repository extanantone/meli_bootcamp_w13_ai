package com.mercadolibre.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublicationsFollowDTO {
    @NotNull(message = "El id del usuario a seguir no debe estar vacio")
    private Integer userId;
    @NotEmpty(message = "La lista de publicaciones no puede estar vacia")
    List<PublicationDTO> posts;

    @Override
    public String toString() {
        return "PublicationsFollowDTO{" +
                "userId=" + userId +
                ", posts=" + posts +
                '}';
    }
}
