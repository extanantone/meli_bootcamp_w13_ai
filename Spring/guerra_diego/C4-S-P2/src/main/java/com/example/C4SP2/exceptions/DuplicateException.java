package com.example.C4SP2.exceptions;

public class DuplicateException extends RuntimeException {

    public DuplicateException() {
    }

    public DuplicateException(String message) {
        super(message);
    }
}
