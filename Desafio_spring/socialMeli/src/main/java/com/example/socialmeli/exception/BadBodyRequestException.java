package com.example.socialmeli.exception;

public class BadBodyRequestException extends RuntimeException{
    public BadBodyRequestException(String message){
        super(message);
    }
}
