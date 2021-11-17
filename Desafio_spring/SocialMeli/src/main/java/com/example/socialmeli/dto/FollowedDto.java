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
public class FollowedDto extends UserDto{

    private List<UserDto> followed = new ArrayList<>();

    public FollowedDto(User user, List<UserDto> followed) {
        super(user);
        this.followed = followed;
    }
}
