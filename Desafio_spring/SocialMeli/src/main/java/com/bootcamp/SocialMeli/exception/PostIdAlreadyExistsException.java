package com.bootcamp.SocialMeli.exception;

public class PostIdAlreadyExistsException extends RuntimeException{

    public PostIdAlreadyExistsException(Integer id) {

        super( "El post ya tiene un ID: " + id  );
    }
}
