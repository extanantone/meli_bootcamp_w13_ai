package com.example.socialmeli.model;

import com.example.socialmeli.dto.UserDto;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class User {
    private Integer userId;
    private String userName;
    private Map<Integer, UserDto> followers = new HashMap<>();
    private Map<Integer,UserDto> followed = new HashMap<>();

    public void addFollower(UserDto userDto) {
        followers.put(userDto.getUserId(),userDto);

    }

    public void addFollowed(UserDto userDto) {
        followed.put(userDto.getUserId(),userDto);
    }

    public void removeFollower(UserDto userDto) {
        followers.remove(userDto.getUserId());
    }

    public void removeFollowed(UserDto userDto) {
        followed.remove(userDto.getUserId());
    }


}
