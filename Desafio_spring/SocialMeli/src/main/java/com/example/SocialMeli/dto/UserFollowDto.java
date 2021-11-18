package com.example.SocialMeli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class UserFollowDto {

    private int userId;
    private String userName;
    private List<UserDto> followers;
    private List<UserDto> followed;

    public void addFollower(UserDto user){
        this.followers.add(user);
    }

    public void addFollowed(UserDto user){
        this.followed.add(user);
    }
}
