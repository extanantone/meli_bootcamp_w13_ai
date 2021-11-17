package com.bootcamp.SocialMeli.exception;

public class UserIsNotFollowingException extends RuntimeException{
    public UserIsNotFollowingException(int followerId, int followedId) {
        super(String.format("User with id %d is not following user with id %d", followerId, followedId));
    }
}
