package com.example.SocialMeli.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends SocialMeliException {

    public UserNotFoundException(Integer id) {
        super("No se pudo encontrar el usuario con el id: "+id, HttpStatus.NOT_FOUND);
    }
}
