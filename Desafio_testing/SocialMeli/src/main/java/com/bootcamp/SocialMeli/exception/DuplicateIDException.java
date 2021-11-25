package com.bootcamp.SocialMeli.exception;

public class DuplicateIDException extends RuntimeException{
    public DuplicateIDException(String mensaje) {
        super(mensaje);
    }
}
