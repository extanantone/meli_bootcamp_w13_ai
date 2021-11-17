package com.bootcamp.SocialMeli.exception;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(int id) {
        super(String.format("User with id %d already exists", id));
    }
}
