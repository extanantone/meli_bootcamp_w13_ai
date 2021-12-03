package com.bootcamp.SocialMeli.dto;

import com.bootcamp.SocialMeli.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserFollowersDTO {
    private int userId;
    private String userName;
    private List<User> followers;
    public UserFollowersDTO(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.followers = new ArrayList<>();
    }
    public UserFollowersDTO(int userId, String userName, List<User> followers) {
        this.userId = userId;
        this.userName = userName;
        this.followers = followers;
    }
}
