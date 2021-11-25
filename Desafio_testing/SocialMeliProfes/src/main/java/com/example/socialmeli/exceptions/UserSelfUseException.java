package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class UserSelfUseException extends SocialMeliException{
    public UserSelfUseException(Integer id) {
        super("EL USUARIO CON ID " + id + " SE ESTÁ LLAMANDO A Sí MISMO", HttpStatus.BAD_REQUEST);
    }
}
