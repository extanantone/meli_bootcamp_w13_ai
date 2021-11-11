package com.bootcamp.apimessengers.exception;

public class NotFoundMessengerException extends RuntimeException{

    public NotFoundMessengerException(Long id) {
        super(String.format("The messenger identified by id = %s doesn't exist"));
    }
}
