package com.sprint.SocialMeli.exceptions;

// Indica si un nuevo post tiene el mismo ID que uno ya existente
public class DuplicateException extends Exception{

    public DuplicateException(String message){
        super(message);
    }
}