package com.bootcamp.SocialMeli.mapper;

import com.bootcamp.SocialMeli.dto.UserDTO;
import com.bootcamp.SocialMeli.model.User;

public class UserMapper {

    public static User  UserDTOToUser (UserDTO userDTO){

        return new User(userDTO.getUser_id(), userDTO.getUser_name());
    }

    public static UserDTO userToUserDTO(User user){

        return new UserDTO(user.getId(), user.getTipo()+":"+ user.getUserName());
    }

}
