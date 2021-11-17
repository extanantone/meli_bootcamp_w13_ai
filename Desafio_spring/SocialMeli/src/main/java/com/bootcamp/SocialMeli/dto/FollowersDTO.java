package com.bootcamp.SocialMeli.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FollowersDTO extends UserDTO {
    private List<UserDTO> followers;

    public FollowersDTO(Integer userId, String userName, List<UserDTO> followers) {
        super(userId, userName);
        this.followers = followers;
    }

}
