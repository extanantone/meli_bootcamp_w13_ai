package com.SocialMeli.SocialMeli.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException{

    public UserNotFoundException(Integer id){
        super("El usuario con Id " + id + " no se encuentra registrado.", HttpStatus.NOT_FOUND);

    }
}
