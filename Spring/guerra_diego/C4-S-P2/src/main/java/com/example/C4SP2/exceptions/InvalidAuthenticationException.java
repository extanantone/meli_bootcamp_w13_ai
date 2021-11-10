package com.example.C4SP2.exceptions;

public class InvalidAuthenticationException extends RuntimeException{

    public InvalidAuthenticationException() {
    }

    public InvalidAuthenticationException(String message) {
        super(message);
    }

}
