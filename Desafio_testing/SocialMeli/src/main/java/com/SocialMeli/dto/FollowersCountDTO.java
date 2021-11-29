package com.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FollowersCountDTO extends UserDTO {
    private Integer followersCount;

    public FollowersCountDTO(Integer userId, String userName, Integer followersCount) {
        super(userId, userName);
        this.followersCount = followersCount;
    }
}
