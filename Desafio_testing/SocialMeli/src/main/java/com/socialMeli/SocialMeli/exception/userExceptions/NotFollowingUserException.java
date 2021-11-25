package com.socialMeli.SocialMeli.exception.userExceptions;

public class NotFollowingUserException extends  RuntimeException{
    public NotFollowingUserException() {
        super("No se sigue al usuario");
    }
}
