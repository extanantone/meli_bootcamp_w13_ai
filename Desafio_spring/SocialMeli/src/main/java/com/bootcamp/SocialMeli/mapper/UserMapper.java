package com.bootcamp.SocialMeli.mapper;

import com.bootcamp.SocialMeli.dto.CountDTO;
import com.bootcamp.SocialMeli.dto.FollowedDTO;
import com.bootcamp.SocialMeli.dto.FollowerDTO;
import com.bootcamp.SocialMeli.dto.UserDTO;
import com.bootcamp.SocialMeli.model.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {
    public CountDTO countDTO(User user){
        CountDTO countDTO = new CountDTO();
        countDTO.setUser_id(user.getUser_id());
        countDTO.setUser_name(user.getUser_name());
        countDTO.setCount(user.getFollowers().size());
        return countDTO;
    }

    public FollowerDTO followerDTO(User user){
        FollowerDTO followerDTO = new FollowerDTO();
        followerDTO.setUser_id(user.getUser_id());
        followerDTO.setUser_name(user.getUser_name());
        followerDTO.setFollowers(user.getFollowers().stream().map(users ->
                new UserDTO(users.getUser_id(), users.getUser_name()))
                .collect(Collectors.toList()));
        return followerDTO;
    }

    public FollowedDTO followedDTO(User user) {
        FollowedDTO followedDTO = new FollowedDTO();
        followedDTO.setUser_id(user.getUser_id());
        followedDTO.setUser_name(user.getUser_name());
        followedDTO.setFollowed(user.getFollowed().stream().map(users ->
                new UserDTO(users.getUser_id(), users.getUser_name()))
                .collect(Collectors.toList()));
        return followedDTO;
    }
}
