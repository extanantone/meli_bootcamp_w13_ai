package com.socialmeli.exception;

public class InvalidPostException extends RuntimeException{

    public InvalidPostException(String ms){
        super(ms);
    }
}
