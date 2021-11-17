package com.bootcamp.SocialMeli.exception;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(int id) {
        super(String.format("Post with id %d was not found", id));
    }
}
