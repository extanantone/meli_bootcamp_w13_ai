package com.example.socialmeli.exception;

public class UserIdNotFoundException extends RuntimeException{
    public UserIdNotFoundException(Integer id){
        super("Given user ID doesn't exist: " + id);
    }
}
