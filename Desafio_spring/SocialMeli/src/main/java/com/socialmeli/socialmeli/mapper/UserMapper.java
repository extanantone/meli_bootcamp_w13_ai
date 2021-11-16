package com.socialmeli.socialmeli.mapper;

import com.socialmeli.socialmeli.dto.user.UserDTO;
import com.socialmeli.socialmeli.dto.user.UserFollowerCountDTO;
import com.socialmeli.socialmeli.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserFollowerCountDTO userToUserFollowerDTO(User user){
        return new UserFollowerCountDTO(user.getUser_id(),user.getUser_name(),user.countFollowers());
    }

    public UserDTO userToUserDTO(User user){
        return new UserDTO(user.getUser_id(),user.getUser_name());
    }


}
