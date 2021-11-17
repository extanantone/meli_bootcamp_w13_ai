package com.bootcamp.SocialMeli.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowerCountDTO extends UserDTO {
    private Integer followersCount;

    public FollowerCountDTO(Integer userId, String userName, Integer followersCount) {
        super(userId, userName);
        this.followersCount = followersCount;
    }

}
