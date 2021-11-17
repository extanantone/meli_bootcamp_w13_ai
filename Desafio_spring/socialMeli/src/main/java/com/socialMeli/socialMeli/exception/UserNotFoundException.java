package com.socialMeli.socialMeli.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super(String.format("No existe uno de los usuarios implicados"));
    }
}
