package com.bootcamp.SocialMeli.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserIdNotFoundException extends RuntimeException{
    public UserIdNotFoundException(Integer id) {

        super( "No se pudo encontrar el usuario con el ID: " + id  );
}}
