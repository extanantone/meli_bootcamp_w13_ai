package com.example.SocialMeli.exceptions;

public class DuplicateFollowException extends RuntimeException{
    public DuplicateFollowException() {
    }

    public DuplicateFollowException(String message) {
        super(message);
    }
}
