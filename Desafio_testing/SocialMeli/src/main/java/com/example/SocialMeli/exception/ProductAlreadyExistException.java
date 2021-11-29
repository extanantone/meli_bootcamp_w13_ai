package com.example.SocialMeli.exception;

import org.springframework.http.HttpStatus;

public class ProductAlreadyExistException extends SocialMeliException {
    public ProductAlreadyExistException(Integer id) {
        super("El post con el id: "+id+" ya existe.", HttpStatus.NOT_FOUND);
    }
}