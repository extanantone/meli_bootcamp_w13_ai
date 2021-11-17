package com.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FollowersDTO extends UserDTO {
    private List<UserDTO> followers = new ArrayList<>();

    public FollowersDTO(int userId, String userName) {
        super(userId, userName);
    }
}
