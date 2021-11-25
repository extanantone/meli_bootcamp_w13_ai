package com.bootcamp.socialmeli.exception;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException() { super("Usuario no encontrado"); }

    public PostNotFoundException(String message) {
        super(message);
    }

    public PostNotFoundException(Object id){
        super("Usuario no encontrado id: " + id);
    }
}
