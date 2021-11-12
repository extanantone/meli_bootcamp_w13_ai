package com.bootcamp.socialmeli.exception;

public class NotFoundUsuarioException extends RuntimeException{
    public NotFoundUsuarioException(Integer id) {
        super( "No encontramos Usuario: " + id );
    }
}