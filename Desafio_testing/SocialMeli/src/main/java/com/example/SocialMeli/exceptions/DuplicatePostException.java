package com.example.SocialMeli.exceptions;

import com.example.SocialMeli.exceptions.handler.SocialMeliException;
import org.springframework.http.HttpStatus;

public class DuplicatePostException extends SocialMeliException {

    public DuplicatePostException(int idPublication) {
        super("Ya existe una publicación con el ID "+idPublication, HttpStatus.BAD_REQUEST);
    }
}
