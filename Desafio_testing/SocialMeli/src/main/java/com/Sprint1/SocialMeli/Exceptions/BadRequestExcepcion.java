package com.Sprint1.SocialMeli.Exceptions;

public class BadRequestExcepcion extends RuntimeException{
    public BadRequestExcepcion() {
    }

    public BadRequestExcepcion(String message) {
        super(message);
    }
}
