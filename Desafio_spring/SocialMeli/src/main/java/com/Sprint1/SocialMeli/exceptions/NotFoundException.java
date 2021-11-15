package com.Sprint1.SocialMeli.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException() {
    }

    public NotFoundException (String message){
        super(message);
    }
}
