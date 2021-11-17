package com.SprintI.SocialMeli.repositories;

import com.SprintI.SocialMeli.models.User;

import java.util.List;


public interface UserRepository {

    User findById(int id);
    List<User> getUsers();
    //List<Post> getPostFollowed(int id);

}
