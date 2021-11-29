package com.mercadolibre.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FollowersCountDTO extends UserDTO{
    private int followersCount;

    public FollowersCountDTO(@NotNull(message = "La id no puede estar vacía")
                             @Positive(message = "El id debe ser mayor a cero") int id,
                             @NotBlank(message = "El nombre del usuario no puede estar vacio") String name,
                             int followersCount) {
        super(id, name);
        this.followersCount = followersCount;
    }
}
