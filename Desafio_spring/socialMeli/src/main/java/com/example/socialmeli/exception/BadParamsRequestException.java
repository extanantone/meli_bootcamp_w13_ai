package com.example.socialmeli.exception;

public class BadParamsRequestException extends RuntimeException{
    public BadParamsRequestException(String message){
        super(message);
    }
}
