package com.bootcamp.SocialMeli.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCountFollowersDTO {
    private int userId;
    private String userName;
    private int followersCount;

    public UserCountFollowersDTO(int userId, String userName, int followersCount) {
        this.userId = userId;
        this.userName = userName;
        this.followersCount = followersCount;
    }
}