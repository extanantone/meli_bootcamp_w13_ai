package com.bootcamp.socialmeli.exceptions;

public class BadRequestException extends RuntimeException {

    private String message;

    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }
}
