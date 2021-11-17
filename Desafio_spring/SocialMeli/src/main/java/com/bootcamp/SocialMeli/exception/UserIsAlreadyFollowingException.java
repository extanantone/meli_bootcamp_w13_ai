package com.bootcamp.SocialMeli.exception;

public class UserIsAlreadyFollowingException extends RuntimeException {
    public UserIsAlreadyFollowingException(int followerId, int followedId) {
        super(String.format("User with id %d is already following user with id %d", followerId, followedId));
    }
}
