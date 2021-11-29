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
public class UserFollowersListDTO extends UserDTO {
    private List<UserDTO> followers;

    public UserFollowersListDTO(int userId, String userName, List<UserDTO> followers) {
        super(userId, userName);
        this.followers = followers;
    }
}