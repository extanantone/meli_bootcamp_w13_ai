package com.example.redirect.exceptions;

public class AlreadyAddLinkException extends  RuntimeException {
    public AlreadyAddLinkException() {
    }

    public AlreadyAddLinkException(String message) {
        super(message);
    }
}
