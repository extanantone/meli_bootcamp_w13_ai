package com.example.SocialMeli.services;

public interface UserService {

    Boolean saveFollow(int user_id, int toFollow) throws Exception;
}
