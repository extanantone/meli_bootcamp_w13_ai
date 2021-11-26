package com.bootcamp.SocialMeli.dto.publicacion;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublicacionFollowedDTO {
    @NotNull(message = "La id no puede estar vacía.")
    @Positive(message = "El id debe ser mayor a cero.")
    private Integer userId;

    private List<PublicacionDTO> posts;
}
