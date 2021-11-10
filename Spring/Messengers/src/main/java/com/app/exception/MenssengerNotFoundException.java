package com.app.exception;

public class MenssengerNotFoundException extends RuntimeException{

    public MenssengerNotFoundException(String ms){
        super(ms);
    }

}
