package com.bootcamp.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDTO {

    private Integer userId;
    private String userName;

    public UserDTO(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

}
