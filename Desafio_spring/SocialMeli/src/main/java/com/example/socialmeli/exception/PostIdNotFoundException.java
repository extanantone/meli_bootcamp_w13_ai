package com.example.socialmeli.exception;

public class PostIdNotFoundException extends RuntimeException{
    public PostIdNotFoundException(Integer id){
        super("Given post ID doesn't exist: " + id);
    }
}