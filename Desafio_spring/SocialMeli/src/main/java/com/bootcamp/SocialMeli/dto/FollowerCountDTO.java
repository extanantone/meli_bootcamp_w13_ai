package com.bootcamp.SocialMeli.dto;

public class FollowerCountDTO extends UserDTO{
    private Integer followersCount;

    public FollowerCountDTO(Integer userId, String userName, Integer followersCount) {
        super(userId, userName);
        this.followersCount = followersCount;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }
}
