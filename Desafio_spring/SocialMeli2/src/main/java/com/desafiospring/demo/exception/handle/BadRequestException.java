package com.desafiospring.demo.exception.handle;

public class BadRequestException extends RuntimeException {
    private String message;

    public BadRequestException(){

    }

    public BadRequestException(String message){
        super(message);
    }
}
