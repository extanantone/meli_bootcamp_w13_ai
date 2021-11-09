package com.example.blog.exceptions;

public class NullPointerException extends RuntimeException{
    public NullPointerException() {
    }

    public NullPointerException(String message) {
        super(message);
    }
}
