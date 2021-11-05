package com.example.linktracker.exeption;


public class MissingBodyException extends RuntimeException{
    public MissingBodyException() {
    }

    public MissingBodyException(String message) {
        super(message);
    }
}
