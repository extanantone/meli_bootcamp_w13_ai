package com.bootcamp.SocialMeli.exception;

public class PostAlreadyExistsException extends RuntimeException{
    public PostAlreadyExistsException(int id) {
        super(String.format("Post with id %d already exists", id));
    }
}
