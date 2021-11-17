package com.bootcamp.SocialMeli.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FollowedDTO extends UserDTO {
    private List<UserDTO> followed;

    public FollowedDTO(Integer userId, String userName, List<UserDTO> followed) {
        super(userId, userName);
        this.followed = followed;
    }

}
