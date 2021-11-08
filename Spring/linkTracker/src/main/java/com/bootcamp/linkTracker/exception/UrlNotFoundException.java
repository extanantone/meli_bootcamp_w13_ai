package com.bootcamp.linkTracker.exception;

public class UrlNotFoundException extends RuntimeException{
    public UrlNotFoundException(String msg){
        super(msg);
    }

}
