package com.bootcamp.SocialMeli.dto;

import com.bootcamp.SocialMeli.model.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FollowersCountDTO {
    int userId;
    String userName;
    int followersCount;

    public FollowersCountDTO(int userId, String userName, List<User> followers) {
        this.userId = userId;
        this.userName = userName;
        this.followersCount = followers.size();
    }
}
