package com.example.C4SP2.exceptions;

public class InvalidLinkException extends RuntimeException{
    public InvalidLinkException() {
    }

    public InvalidLinkException(String message) {
        super(message);
    }
}
