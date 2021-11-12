package com.bootcamp.socialmeli.mapper;

import com.bootcamp.socialmeli.dto.UserCreationDTO;
import com.bootcamp.socialmeli.dto.UserDTO;
import com.bootcamp.socialmeli.model.User;
import org.springframework.stereotype.Component;

@Component
public class Mapper implements IMapper {

    public UserDTO UserToUserDTO(User user) {
        return new UserDTO(user.getId(), user.getUsername());
    }

    public User UserCreationDTOToUser(UserCreationDTO userCreationDTO) {
        return new User(userCreationDTO.getUsername(), userCreationDTO.getEmail(), userCreationDTO.getPassword());
    }
}
