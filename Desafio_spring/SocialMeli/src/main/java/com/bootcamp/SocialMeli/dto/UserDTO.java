package com.bootcamp.SocialMeli.dto;

import com.bootcamp.SocialMeli.model.User;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDTO implements Serializable {
    int userId;
    String userName;
    public UserDTO(User user) {
        this.userId = user.getId();
        this.userName = user.getName();
    }
}
