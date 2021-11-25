package com.socialMeli.SocialMeli.exception.userExceptions;

public class AlreadyFollowedUserException extends RuntimeException{
    public AlreadyFollowedUserException() {
        super("Ya se sigue al usuario");
    }
}

