package com.bootcamp.socialmeli.exception;

public class InternalServerError extends RuntimeException{
    public InternalServerError() {
        super("Error Interno del Servidor");
    }

    public InternalServerError(String message) {
        super(message);
    }
}
