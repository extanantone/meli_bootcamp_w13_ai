package com.example.socialmeli.dto;

import com.example.socialmeli.model.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FollowersDto extends UserDto{

    private List<UserDto> followers = new ArrayList<>();
    private Integer followersCount;


    public FollowersDto(User user, List<UserDto> followers) {
        super(user);
        this.followers = followers;
    }

    public FollowersDto(User user) {
        super(user);
    }
}
