package com.bootcamp.socialmeli.mapper;

import com.bootcamp.socialmeli.dto.*;
import com.bootcamp.socialmeli.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper implements IUserMapper{

/*
    @Override
    public User userFromUserDTO(UserDTO userDTO) {
        return null;
    }
*/

    @Override
    public UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO(user.getId(), user.getName());
        return userDTO;
    }

    @Override
    public UserTotalFollowersDTO toUserTotalFollowersDTO(User user, int totalFollowers) {
        UserTotalFollowersDTO userTotalFollowersDTO = new UserTotalFollowersDTO(
                user.getId(),
                user.getName(),
                totalFollowers);
        return userTotalFollowersDTO;
    }

    @Override
    public List<UserDTO> userListToUserListDTO(List<User> userList) {
        List<UserDTO> userListDTO = new ArrayList<>();
        for(User u : userList){
            UserDTO userDTO = userToUserDTO(u);
            userListDTO.add(userDTO);
        }
        return  userListDTO;
    }


    @Override
    public UserFollowersDTO toUserFollowersDTO(User user, List<User> followers) {
        List<UserDTO> followersListDTO = userListToUserListDTO(followers);

        UserFollowersDTO userFollowersDTO = new UserFollowersDTO(user.getId(), user.getName(), followersListDTO);
        return userFollowersDTO;
    }

    @Override
    public UserFollowedDTO toUserFollowedDTO(User user, List<User> followed) {
        List<UserDTO> followedListDTO = userListToUserListDTO(followed);

        UserFollowedDTO userFollowedDTO = new UserFollowedDTO(user.getId(), user.getName(), followedListDTO);
        return userFollowedDTO;
    }


}
