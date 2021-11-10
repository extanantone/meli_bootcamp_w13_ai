package com.bootcamp.linktracker.exception;

public class NotFoundLinkException extends RuntimeException{

    public NotFoundLinkException(String message) {
        super(message);
    }
}
