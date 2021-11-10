package com.example.linktracker.exceptions;

public class BadRequestException extends  RuntimeException{
    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }
}
