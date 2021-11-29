package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class PostAlreadyExistException extends SocialMeliException{

    public PostAlreadyExistException (Integer idPost, Integer idUser) {
        super("La publicación con id " + idPost + " ya existe para el usuario con id " +
                idUser, HttpStatus.BAD_REQUEST);
    }
}
