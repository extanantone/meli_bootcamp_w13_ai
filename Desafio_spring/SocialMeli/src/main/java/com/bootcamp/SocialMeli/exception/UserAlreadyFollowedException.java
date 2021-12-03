package com.bootcamp.SocialMeli.exception;

public class UserAlreadyFollowedException extends RuntimeException{
    public UserAlreadyFollowedException(Integer id) {

        super( "Usted ya sigue al usuario con ID: " + id  );
}}
