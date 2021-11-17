package com.example.socialmeli.exceptions;

public class ErrorInOperation extends RuntimeException {
    public ErrorInOperation() {
    }

    public ErrorInOperation(String message) {
        super(message);
    }
}
