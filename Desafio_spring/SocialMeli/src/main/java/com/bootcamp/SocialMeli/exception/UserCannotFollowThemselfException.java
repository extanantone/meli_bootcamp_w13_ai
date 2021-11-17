package com.bootcamp.SocialMeli.exception;

public class UserCannotFollowThemselfException extends RuntimeException {
    public UserCannotFollowThemselfException(int id) {
        super(String.format("User with id %d cannot follow themself", id));
    }
}
