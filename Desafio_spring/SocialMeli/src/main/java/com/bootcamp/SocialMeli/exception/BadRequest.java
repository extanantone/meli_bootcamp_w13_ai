package com.bootcamp.SocialMeli.exception;

public class BadRequest extends RuntimeException {

    public BadRequest(String msj) {
        super(format(msj));
    }

    private static String format(String msj) {

        return new StringBuilder().append(msj).toString();
    }
}
