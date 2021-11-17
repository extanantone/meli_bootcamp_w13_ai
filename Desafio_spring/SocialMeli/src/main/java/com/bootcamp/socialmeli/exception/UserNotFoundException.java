package com.bootcamp.socialmeli.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() { super("Usuario no encontrado"); }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(Object id){
        super("Usuario no encontrado id: " + id);
    }
}
