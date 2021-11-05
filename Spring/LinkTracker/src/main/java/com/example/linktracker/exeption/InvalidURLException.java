package com.example.linktracker.exeption;

public class InvalidURLException extends RuntimeException{
    public InvalidURLException(String message) {
        super(message);
    }

    public InvalidURLException() {
        super("La URL solicitada no es valida");
    }
}
