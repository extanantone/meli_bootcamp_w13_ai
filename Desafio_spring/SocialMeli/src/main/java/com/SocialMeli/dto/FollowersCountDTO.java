package com.SocialMeli.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FollowersCountDTO extends UserDTO {
    private int followersCount;

    public FollowersCountDTO(int user_id, String userName, int followersCount) {
        super(user_id, userName);
        this.followersCount = followersCount;
    }
}
