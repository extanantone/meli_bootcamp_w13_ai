package com.socialMeli.socialMeli.exception;
public class UserFollowingAnotherUserTwice extends RuntimeException{
    public UserFollowingAnotherUserTwice(){
        super(String.format("No se puede seguir dos veces al mismo usuario"));
    }
}
