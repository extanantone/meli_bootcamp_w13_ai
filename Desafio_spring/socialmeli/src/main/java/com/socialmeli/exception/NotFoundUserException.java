package com.socialmeli.exception;

public class NotFoundUserException extends RuntimeException{

    public NotFoundUserException(String ms){
        super(ms);
    }

}
