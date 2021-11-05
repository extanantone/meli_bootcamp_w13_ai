package com.example.linktracker.exeption;

public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException() {
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
