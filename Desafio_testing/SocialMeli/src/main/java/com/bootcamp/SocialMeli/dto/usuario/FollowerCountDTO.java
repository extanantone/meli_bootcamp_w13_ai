package com.bootcamp.SocialMeli.dto.usuario;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FollowerCountDTO {
    @NotNull(message = "La id no puede estar vacía.")
    @Positive(message = "El id debe ser mayor a cero.")
    private Integer userId;

    private String userName;
    private Integer followersCount;
}
