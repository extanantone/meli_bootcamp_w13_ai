package com.mercadolibre.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.NotNull;

/*
     The params can by used by to follow a user/seller and unfollow
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FollowDTO {
    @NotNull(message = "Debe ingresar el id del usuario")
    private int userId;
    @NotNull(message = "El id del usuario a seguir no debe ser nulo")
    private int idUserToFollow;

    @Override
    public String toString() {
        return "FollowDTO{" +
                "userId=" + userId +
                ", idUserToFollow=" + idUserToFollow +
                '}';
    }
}
