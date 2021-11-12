package com.bootcamp.SocialMeli.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String mensaje){
        super(mensaje);
    }
}
