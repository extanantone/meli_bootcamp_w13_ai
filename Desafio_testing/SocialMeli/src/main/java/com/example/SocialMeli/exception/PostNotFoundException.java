package com.example.SocialMeli.exception;

import org.springframework.http.HttpStatus;

public class PostNotFoundException extends SocialMeliException {
    public PostNotFoundException(Integer id) {
        super("No se pudo encontrar el post con el id: "+id, HttpStatus.NOT_FOUND);
    }
}
