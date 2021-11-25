package com.Sprint1.SocialMeli.mapper;

import com.Sprint1.SocialMeli.dto.FollowerDTO;
import com.Sprint1.SocialMeli.dto.FollowersListDTO;
import com.Sprint1.SocialMeli.model.User;

import java.util.List;

public class UserMapper {

    public static FollowersListDTO listFollowersDTOtoFollowerListDTO (User user, List<FollowerDTO> followerDTO){
        FollowersListDTO followersListDTO = new FollowersListDTO();
        followersListDTO.setUser_id(user.getUser_id());
        followersListDTO.setUser_name(user.getUser_name());
        followersListDTO.setFollowers(followerDTO);
        return followersListDTO;
    }

}
