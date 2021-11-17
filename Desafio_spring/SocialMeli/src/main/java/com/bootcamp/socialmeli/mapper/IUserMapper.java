package com.bootcamp.socialmeli.mapper;

import com.bootcamp.socialmeli.dto.*;
import com.bootcamp.socialmeli.model.User;

import java.util.List;

public interface IUserMapper {
    UserDTO userToUserDTO(User user);
    UserTotalFollowersDTO toUserTotalFollowersDTO(User user, int totalFollowers);
    List<UserDTO> userListToUserListDTO(List<User> userList);
    UserFollowersDTO toUserFollowersDTO(User user, List<User> followers);
    UserFollowedDTO toUserFollowedDTO(User user, List<User> followed);
}
