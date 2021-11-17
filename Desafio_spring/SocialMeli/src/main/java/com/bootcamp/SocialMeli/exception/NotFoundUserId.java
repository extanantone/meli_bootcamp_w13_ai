package com.bootcamp.SocialMeli.exception;

public class NotFoundUserId extends RuntimeException{
    public NotFoundUserId(Integer user_id){
        super(String.format("No existe usuario con el id %d", user_id));
    }
}
