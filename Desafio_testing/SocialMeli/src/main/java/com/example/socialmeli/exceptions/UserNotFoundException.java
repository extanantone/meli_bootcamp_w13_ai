package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

import java.util.function.Supplier;

public class UserNotFoundException extends SocialMeliException{

    public UserNotFoundException (Integer userId) {
        super("El usuario con id " + userId + " no puede ser encontrado.", HttpStatus.NOT_FOUND);
    }


}
