package com.bootcamp.socialmeli.mapper;

import com.bootcamp.socialmeli.dto.UserCreationDTO;
import com.bootcamp.socialmeli.dto.UserDTO;
import com.bootcamp.socialmeli.model.User;

public interface IMapper {

    public UserDTO UserToUserDTO(User user);
    public User UserCreationDTOToUser(UserCreationDTO userCreationDTO);
}
