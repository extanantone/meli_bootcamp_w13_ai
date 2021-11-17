package com.bootcamp.SocialMeli.dto;

import java.util.List;

public class FollowersDTO extends UserDTO{
    private List<UserDTO> followers;

    public FollowersDTO(Integer userId, String userName, List<UserDTO> followers) {
        super(userId, userName);
        this.followers = followers;
    }

    public List<UserDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserDTO> followers) {
        this.followers = followers;
    }
}
