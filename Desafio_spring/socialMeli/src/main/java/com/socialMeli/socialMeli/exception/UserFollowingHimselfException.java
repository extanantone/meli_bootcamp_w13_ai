package com.socialMeli.socialMeli.exception;
public class UserFollowingHimselfException extends RuntimeException{
    public UserFollowingHimselfException(){
        super(String.format("Un usuario no puede seguirse a si mismo"));
    }
}
