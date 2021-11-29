package com.bootcamp.SocialMeli.exceptions;

public class NoValidOrderException extends RuntimeException {
    public NoValidOrderException() {
    }

    public NoValidOrderException(String message) {
        super(message);
    }
}
