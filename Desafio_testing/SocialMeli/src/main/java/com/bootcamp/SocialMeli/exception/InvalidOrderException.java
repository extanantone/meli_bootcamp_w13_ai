package com.bootcamp.SocialMeli.exception;

public class InvalidOrderException extends RuntimeException {

    public InvalidOrderException(String order) {
        super("El orden " + order + " no es un método de ordenamiento válido.");
    }
}