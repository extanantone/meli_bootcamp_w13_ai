package com.bootcamp.SocialMeli.exception;

public class FutureDateException extends RuntimeException{
    public FutureDateException(String mensaje) {
        super(mensaje);
    }
}
