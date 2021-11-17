package com.bootcamp.socialmeli.mapper;

import com.bootcamp.socialmeli.dto.FollowedListResponseDTO;
import com.bootcamp.socialmeli.dto.FollowerListResponseDTO;
import com.bootcamp.socialmeli.dto.UserDTO;
import com.bootcamp.socialmeli.entity.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {
    public FollowerListResponseDTO userToFollowerList(User user){
        return new FollowerListResponseDTO(user.getUserId(),
                user.getUserName(),
                user.getFollowers().stream().map(x -> new UserDTO(x.getUserId(), x.getUserName())).collect(Collectors.toList()));
    }

    public FollowedListResponseDTO userToFollowedList(User user){
        return new FollowedListResponseDTO(user.getUserId(),
                user.getUserName(),
                user.getFollowed().stream().map(x -> new UserDTO(x.getUserId(), x.getUserName())).collect(Collectors.toList()));
    }

    public UserDTO userToUserDTO(User user){
        return new UserDTO(user.getUserId(), user.getUserName());
    }
}
