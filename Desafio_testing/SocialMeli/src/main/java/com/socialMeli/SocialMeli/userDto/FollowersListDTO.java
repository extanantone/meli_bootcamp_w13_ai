package com.socialMeli.SocialMeli.userDto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FollowersListDTO {
    private Integer user_id;
    private String user_name;
    private List<UserInfoDTO> followers = new ArrayList<>();

    public FollowersListDTO(Integer id, String username) {
        this.user_id=id;
        this.user_name=username;
    }

    public FollowersListDTO(Integer id, String username, List followers) {
        this.user_id=id;
        this.user_name=username;
        this.followers=followers;
    }

    public void addFollowerDTO(UserInfoDTO follower){
        followers.add(follower);
    }
}
