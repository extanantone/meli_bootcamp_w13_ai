package com.bootcamp.SocialMeli.dto;

import java.util.List;

public class FollowedDTO extends UserDTO{
    private List<UserDTO> followed;

    public FollowedDTO(Integer userId, String userName, List<UserDTO> followed) {
        super(userId, userName);
        this.followed = followed;
    }

    public List<UserDTO> getFollowed() {
        return followed;
    }

    public void setFollowed(List<UserDTO> followed) {
        this.followed = followed;
    }
}
