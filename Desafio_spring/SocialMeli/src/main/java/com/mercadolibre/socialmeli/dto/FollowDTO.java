package com.mercadolibre.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*
     The params can by used by to follow a user/seller and unfollow
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FollowDTO {
    private int userId;
    private int idUserToFollow;

    @Override
    public String toString() {
        return "FollowDTO{" +
                "userId=" + userId +
                ", idUserToFollow=" + idUserToFollow +
                '}';
    }
}
