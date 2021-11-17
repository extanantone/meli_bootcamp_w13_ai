package com.bootcamp.SocialMeli.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(int id) {
        super(String.format("User with id %d was not found", id));
    }
}
