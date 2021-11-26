package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

import java.util.function.Supplier;

public class PostNotFoundException extends SocialMeliException {

    public PostNotFoundException(Integer id) {
        super("NO ES POSIBLE ENCONTRAR EL POST CON ID " + id, HttpStatus.NOT_FOUND);
    }
}
