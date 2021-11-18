package com.example.SocialMeli.exceptions;

public class DuplicatePostException extends RuntimeException{
    public DuplicatePostException() {
    }

    public DuplicatePostException(String message) {
        super(message);
    }
}
