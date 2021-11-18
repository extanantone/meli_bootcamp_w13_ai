package com.example.SocialMeli.exceptions;

public class MissingFieldsException extends RuntimeException{
    public MissingFieldsException() {
    }

    public MissingFieldsException(String message) {
        super(message);
    }
}
