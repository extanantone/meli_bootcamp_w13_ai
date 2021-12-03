package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class UserAlreadyInUseException extends SocialMeliException{

    public UserAlreadyInUseException(Integer userId) {
        super("EL USUARIO CON ID " + userId + " YA ESTÁ EN USO.", HttpStatus.BAD_REQUEST);
    }

}
