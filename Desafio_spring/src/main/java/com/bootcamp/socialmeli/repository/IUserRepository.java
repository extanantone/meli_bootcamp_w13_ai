package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.DTO.DTOCount;
import com.bootcamp.socialmeli.model.User;

public interface IUserRepository {

    public User findById(int idUser);

    public int getCountFollowersOfuser(int idUser);

}
