package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.dto.FollowUserDTO;
import com.bootcamp.socialmeli.dto.UserCreationDTO;
import com.bootcamp.socialmeli.dto.UserDTO;
import com.bootcamp.socialmeli.model.User;

import java.util.List;

public interface IUserService {

    public List<UserDTO> getAll();
    public UserDTO getUser(long id);
    public UserDTO createUser(UserCreationDTO user);
    public boolean deleteUser(long id);
    public boolean followUser(FollowUserDTO followUserDTO);
}
