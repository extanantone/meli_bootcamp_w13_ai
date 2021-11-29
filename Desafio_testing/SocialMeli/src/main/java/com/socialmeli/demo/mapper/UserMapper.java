package com.socialmeli.demo.mapper;

import com.socialmeli.demo.dto.*;
import com.socialmeli.demo.model.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User userDTOToUser(UserDTO userDTO){
        return new User(
                userDTO.getUserId(),
                userDTO.getUserName(),
                userDTO.getName(),
                userDTO.getLastName()
        );
    }

    public UserDTO userToUserDTO(User user){
        return new UserDTO(
                user.getUserId(),
                user.getUserName(),
                user.getName(),
                user.getLastName()
        );
    }

    public User addUserDTOToUser(AddUserDTO addUserDTO){
        return new User(
                addUserDTO.getUserName(),
                addUserDTO.getName(),
                addUserDTO.getLastName()
        );
    }

    public AddUserDTO userToAddUserDTO(User user){
        return new AddUserDTO(
                user.getUserName(),
                user.getName(),
                user.getLastName()
        );
    }

    public UserFollowedDTO userToUserFollowedDTO(User user){
        return new UserFollowedDTO(
                user.getUserId(),
                user.getUserName(),
                user.getFollowed().stream().map(this::userToUserDTO).collect(Collectors.toList())
        );
    }

    public UserFollowersDTO userToUserFollowersDTO(User user){
        return new UserFollowersDTO(
                user.getUserId(),
                user.getUserName(),
                user.getFollowers().stream().map(this::userToUserDTO).collect(Collectors.toList())
        );
    }

    public UserWithFollowersCountDTO userToUserWithFollowersCountDTO(User user){
        return new UserWithFollowersCountDTO(
                user.getUserId(),
                user.getUserName(),
                user.getFollowers().size()
        );
    }
}
