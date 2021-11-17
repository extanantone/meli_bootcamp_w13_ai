package com.bootcamp.SocialMeli.exception;

public class DeniedActionException extends RuntimeException {

    public DeniedActionException() {
        super("No es posible procesar su solicitud.");
    }
}