package com.bootcamp.socialmeli.exception;

public class UserIdNotFound extends RuntimeException{
    public UserIdNotFound (Long idUser) {
        super(String.format("User id not found %d", idUser));
    }
}
