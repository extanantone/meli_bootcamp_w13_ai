package com.meli.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CountFollowersDTO extends UserDTO implements Serializable {
    private int followersCount;

    public CountFollowersDTO(int userId, String userName, int followersCount){
        super(userId, userName);
        this.followersCount=followersCount;
    }
}
