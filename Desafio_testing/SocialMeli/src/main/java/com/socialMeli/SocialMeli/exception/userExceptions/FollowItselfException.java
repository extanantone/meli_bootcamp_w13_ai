package com.socialMeli.SocialMeli.exception.userExceptions;

public class FollowItselfException extends RuntimeException{
    public FollowItselfException() {
        super("No se puede seguir a si mismo");
    }
}
