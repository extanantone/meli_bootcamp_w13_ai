package com.lgoyenechea.socialmeli.dto.mapper;

import com.lgoyenechea.socialmeli.dto.*;
import com.lgoyenechea.socialmeli.model.User;

import java.util.stream.Collectors;

public class UserMapper {

    public static User userCreationDtoToUser(UserCreationDTO creationDTO) {
        User user = new User();
        user.setName(creationDTO.getUserName());
        return user;
    }

    public static UserDTO userToDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getId());
        dto.setUserName(user.getName());
        return dto;
    }

    public static UserFollowDTO userToFollow(User user, User followed) {
        UserDTO dto = userToDto(user);
        UserDTO followedDto = userToDto(followed);
        UserFollowDTO userFollowDto = new UserFollowDTO();
        userFollowDto.setUser(dto);
        userFollowDto.setUserFollowed(followedDto);
        return userFollowDto;
    }

    public static UserFollowersCountDTO userToFollowersCount(User user) {
        UserFollowersCountDTO dto = new UserFollowersCountDTO();
        dto.setUserId(user.getId());
        dto.setUserName(user.getName());
        dto.setFollowersCount(user.getFollowers().size());
        return dto;
    }

    public static UserFollowersListDTO userToFollowersList(User user) {
        UserFollowersListDTO dto = new UserFollowersListDTO();
        dto.setUserId(user.getId());
        dto.setUserName(user.getName());
        dto.setFollowers(user.getFollowers().stream()
                .map(UserMapper::userToDto)
                .collect(Collectors.toList()));
        return dto;
    }

    public static UserFollowedListDTO userToFollowedList(User user) {
        UserFollowedListDTO dto = new UserFollowedListDTO();
        dto.setUserId(user.getId());
        dto.setUserName(user.getName());
        dto.setFollowed(user.getFollowed().stream()
                .map(UserMapper::userToDto)
                .collect(Collectors.toList()));
        return dto;
    }
}
