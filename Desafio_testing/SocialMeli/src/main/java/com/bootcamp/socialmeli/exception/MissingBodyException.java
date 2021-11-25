package com.bootcamp.socialmeli.exception;

public class MissingBodyException extends RuntimeException{
    public MissingBodyException() {
        super("El body de la request es necesario");
    }

    public MissingBodyException(String message) {
        super(message);
    }
}
