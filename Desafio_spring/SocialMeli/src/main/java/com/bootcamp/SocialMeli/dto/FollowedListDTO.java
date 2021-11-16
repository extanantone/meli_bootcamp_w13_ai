package com.bootcamp.SocialMeli.dto;

import com.bootcamp.SocialMeli.model.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FollowedListDTO {
    int userId;
    String userName;
    List<UserDTO> followed;

    public FollowedListDTO(int userId, String userName, List<User> followed) {
        this.userId = userId;
        this.userName = userName;
        this.followed = followed
                .stream()
                .map(user -> new UserDTO(user))
                .collect(Collectors.toList());
    }

}
