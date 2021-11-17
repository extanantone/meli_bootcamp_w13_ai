package com.bootcamp.SocialMeli.exceptions;

public class SameUserException extends RuntimeException {
    public SameUserException() {
    }

    public SameUserException(String message) {
        super(message);
    }

}
