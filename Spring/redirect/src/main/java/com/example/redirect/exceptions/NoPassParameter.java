package com.example.redirect.exceptions;

public class NoPassParameter extends RuntimeException{

    public NoPassParameter() {
    }

    public NoPassParameter(String message) {
        super(message);
    }
}
