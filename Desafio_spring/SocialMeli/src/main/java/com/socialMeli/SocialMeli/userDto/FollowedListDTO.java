package com.socialMeli.SocialMeli.userDto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class FollowedListDTO {
    private Integer user_id;
    private String user_name;
    private List<UserInfoDTO> followed = new ArrayList<>();

    public FollowedListDTO(Integer id, String username) {
        this.user_id=id;
        this.user_name=username;
    }

    public FollowedListDTO(Integer id, String username, List followed) {
        this.user_id=id;
        this.user_name=username;
        this.followed=followed;
    }

    public void addFollowedDTO(UserInfoDTO followedDTO){
        followed.add(followedDTO);
    }
}
