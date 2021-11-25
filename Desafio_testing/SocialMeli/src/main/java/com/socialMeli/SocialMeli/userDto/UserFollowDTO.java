package com.socialMeli.SocialMeli.userDto;

import com.socialMeli.SocialMeli.model.User;

import java.util.List;

public class UserFollowDTO {

    private Integer id;
    private List<Integer> following;

    public UserFollowDTO(User user) {
        this.id = user.getId();
        this.following=user.getFollowing();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getFollowing() {
        return following;
    }

    public void setFollowing(List<Integer> following) {
        this.following = following;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", following=" + following +
                '}';
    }
}
