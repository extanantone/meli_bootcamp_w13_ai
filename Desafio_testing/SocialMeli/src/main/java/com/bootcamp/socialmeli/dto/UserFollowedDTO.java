package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserFollowedDTO extends UserDTO{
    private List<UserDTO> followed;

    public UserFollowedDTO(int userId, String userName) {
        super(userId, userName);
    }

    public UserFollowedDTO(int userId, String userName, List<UserDTO> followed) {
        super(userId, userName);
        this.followed = followed;
    }
}
