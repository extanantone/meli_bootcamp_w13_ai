package com.example.socialmeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.ArrayList;
import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FollowerListDTO {
    private final Integer userId;
    private final String userName;
    public final List<BasicUserDTO> followers;

    public FollowerListDTO(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.followers = new ArrayList<>();
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}
