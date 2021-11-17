package com.example.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class UserResponseDto extends UserDto{
    private Integer followersCount;
    private Integer promoProductsCount;
    private List<UserDto> followers;
    private List<UserDto> followed;

    public UserResponseDto(Integer userId, String userName, Integer followersCount, Integer promoProductsCount, List<UserDto> followers, List<UserDto> followed) {
        this.followersCount = followersCount;
        this.promoProductsCount = promoProductsCount;
        this.followers = followers;
        this.followed = followed;
        super.setUserId(userId);
        super.setUserName(userName);
    }
}
