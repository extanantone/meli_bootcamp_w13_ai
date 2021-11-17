package com.example.socialmeli.exceptions;

public class UserNoFound extends RuntimeException{
    public UserNoFound() {
    }

    public UserNoFound(String message) {
        super(message);
    }
}
