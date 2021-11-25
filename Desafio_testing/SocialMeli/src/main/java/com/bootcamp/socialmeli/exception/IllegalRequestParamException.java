package com.bootcamp.socialmeli.exception;

public class IllegalRequestParamException extends RuntimeException {
    public IllegalRequestParamException() {
    }

    public IllegalRequestParamException(String message) {
        super(message);
    }
}
