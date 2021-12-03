package com.bootcamp.SocialMeli.dto;

import com.bootcamp.SocialMeli.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserFollowedDTO {

    private int userId;
    private String userName;
    private List<User> followed;
    public UserFollowedDTO(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.followed = new ArrayList<>();
    }
    public UserFollowedDTO(int userId, String userName,List<User> followed) {
        this.userId = userId;
        this.userName = userName;
        this.followed = followed;
    }

}
