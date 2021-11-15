package com.bootcamp.SocialMeli.dto;

import com.bootcamp.SocialMeli.model.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDTO {
    int userId;
    String userName;
    public UserDTO(User user) {
        this.userId = user.getId();
        this.userName = user.getName();
    }
}
