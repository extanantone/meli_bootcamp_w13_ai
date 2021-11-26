package com.bootcamp.SocialMeli.exception;

public class NotFoundExceptionUsers extends RuntimeException{

    public NotFoundExceptionUsers(int id){
        super("No se encuentra el user ID:"+id);
    }
}
