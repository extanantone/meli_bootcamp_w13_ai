package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserFollowersDTO extends UserDTO{
    private List<UserDTO> followers;

    public UserFollowersDTO(int userId, String userName) {
        super(userId, userName);
    }

    public UserFollowersDTO(int userId, String userName, List<UserDTO> followers) {
        super(userId, userName);
        this.followers = followers;
    }
}