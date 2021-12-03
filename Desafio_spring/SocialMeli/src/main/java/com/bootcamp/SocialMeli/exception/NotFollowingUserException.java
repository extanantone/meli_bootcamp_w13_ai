package com.bootcamp.SocialMeli.exception;

public class NotFollowingUserException extends RuntimeException{
    public NotFollowingUserException(Integer id) {

        super( "Usted no sigue al usuario con ID: " + id  );
    }
}
