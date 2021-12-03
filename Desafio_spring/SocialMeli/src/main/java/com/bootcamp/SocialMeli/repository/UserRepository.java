package com.bootcamp.SocialMeli.repository;


import com.bootcamp.SocialMeli.dto.UserDTO;

import java.util.List;

public interface UserRepository {

    List<UserDTO> getUsers();
    boolean userExists(int id);

}
