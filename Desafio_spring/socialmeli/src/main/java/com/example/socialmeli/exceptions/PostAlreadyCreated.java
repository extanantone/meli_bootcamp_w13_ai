package com.example.socialmeli.exceptions;

public class PostAlreadyCreated extends RuntimeException{
    public PostAlreadyCreated() {
    }


    public PostAlreadyCreated(String message) {
        super(message);
    }
}
