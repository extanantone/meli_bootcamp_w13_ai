package com.bootcamp.SocialMeli.dto;

import com.bootcamp.SocialMeli.model.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;
import java.util.stream.Collectors;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FollowersListDTO {
    int userId;
    String userName;
    List<UserDTO> followers;

    public FollowersListDTO(int userId, String userName, List<User> followers) {
        this.userId = userId;
        this.userName = userName;
        this.followers = followers
                .stream()
                .map(user -> new UserDTO(user))
                .collect(Collectors.toList());
    }
}
