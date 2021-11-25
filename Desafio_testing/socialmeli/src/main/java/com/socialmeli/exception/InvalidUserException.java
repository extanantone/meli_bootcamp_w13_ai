package com.socialmeli.exception;

public class InvalidUserException extends RuntimeException{

    public InvalidUserException(String ms){
        super(ms);
    }

}
