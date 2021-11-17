package com.bootcamp.SocialMeli.dto.user;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserFollowedListDTO extends UserDTO {
    private List<UserDTO> followed;

    public UserFollowedListDTO(int userId, String userName, List<UserDTO> followed) {
        super(userId, userName);
        this.followed = followed;
    }
}