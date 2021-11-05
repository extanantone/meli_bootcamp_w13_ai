package com.example.redirect.exceptions;

public class LinkNoFound extends RuntimeException{
    public LinkNoFound() {
    }

    public LinkNoFound(String message) {
        super(message);
    }
}
