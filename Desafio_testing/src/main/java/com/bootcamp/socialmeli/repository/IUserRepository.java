package com.bootcamp.socialmeli.repository;

import com.bootcamp.socialmeli.DTO.DTOUser;
import com.bootcamp.socialmeli.model.User;

import java.util.List;

public interface IUserRepository {

    public User findById(int idUser);

    public int getCountFollowersOfuser(int idUser);

    public List<User> getFollowersFromUser(int idUser);

    public List<DTOUser> orderFollowersAndFolloweds(List<DTOUser> dtoUserList, String order);
}
