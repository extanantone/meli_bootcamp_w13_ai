package com.bootcamp.socialmeli.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserTotalFollowersDTO extends UserDTO{
    private int followersCount;

    public UserTotalFollowersDTO(int id, String userName, int followersCount) {
        super(id, userName);
        this.followersCount = followersCount;
    }
}
