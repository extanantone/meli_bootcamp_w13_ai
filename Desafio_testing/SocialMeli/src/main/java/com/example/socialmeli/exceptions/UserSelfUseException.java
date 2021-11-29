package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class UserSelfUseException extends SocialMeliException{
    public UserSelfUseException (Integer id) {
        super("El usuario con id " + id + " no puede dirigirse a sí mismo.", HttpStatus.BAD_REQUEST);
    }
}
