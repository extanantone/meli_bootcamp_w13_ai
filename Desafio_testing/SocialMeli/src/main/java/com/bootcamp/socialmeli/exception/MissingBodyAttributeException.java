package com.bootcamp.socialmeli.exception;

public class MissingBodyAttributeException extends RuntimeException{
    public MissingBodyAttributeException(String message) {
        super(message);
    }
}
