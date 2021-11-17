package com.bootcamp.socialmeli.exception;

public class MissingUserIdException extends RuntimeException{
    public MissingUserIdException() {
        super("Missing user");
    }

    public MissingUserIdException(String message) {
        super(message);
    }
}
