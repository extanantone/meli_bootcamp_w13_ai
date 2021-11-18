package com.bootcamp.socialmeli.exception;

public class FollowFound extends RuntimeException{
    public FollowFound (Long idFollower, Long idFollowed) {
        super(String.format("El usuario %d ya sigue al %d", idFollower, idFollowed));
    }
}
