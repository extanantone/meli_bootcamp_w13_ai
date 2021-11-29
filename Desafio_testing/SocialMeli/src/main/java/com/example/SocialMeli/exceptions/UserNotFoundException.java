package com.example.SocialMeli.exceptions;

import com.example.SocialMeli.exceptions.handler.SocialMeliException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends SocialMeliException {

    public UserNotFoundException(int userId) {
        super("Usuario "+userId+" no encontrado", HttpStatus.NOT_FOUND);
    }
}
