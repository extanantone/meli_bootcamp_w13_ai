package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class UserAlreadyInUseException extends SocialMeliException{

    public UserAlreadyInUseException (Integer userId) {
        super("El usuario con id " + userId + " ya existe.", HttpStatus.BAD_REQUEST);
    }

}
