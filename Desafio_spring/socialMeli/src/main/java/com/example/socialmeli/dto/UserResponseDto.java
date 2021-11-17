package com.example.socialmeli.dto;

import com.example.socialmeli.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class UserResponseDto extends UserDto{
    Integer followersCount;
    Integer promoPostCount;
    //TODO mapper user to userdto
    List<User> followers;
    List<User> followed;

    public UserResponseDto(Integer userId, String userName, Integer followersCount, Integer promoPostCount, List<User> followers, List<User> followed) {
        this.followersCount = followersCount;
        this.promoPostCount = promoPostCount;
        this.followers = followers;
        this.followed = followed;
        super.userId = userId;
        super.userName = userName;
    }
}
