package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class PostAlreadyExistException extends SocialMeliException{

    public PostAlreadyExistException(Integer idPost, Integer idUser) {
        super("EL POST CON EL ID "+ idPost + " YA EXISTE PARA EL USUARIO " + idUser, HttpStatus.BAD_REQUEST);
    }
}
