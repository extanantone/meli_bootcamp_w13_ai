package com.bootcamp.SocialMeli.dto;

import lombok.Data;

import java.util.List;

@Data
public class FollowedDTO extends UserDTO {
    private List<UserDTO> followed;

    public FollowedDTO(Integer userId, String userName, List<UserDTO> followed) {
        super(userId, userName);
        this.followed = followed;
    }

}
