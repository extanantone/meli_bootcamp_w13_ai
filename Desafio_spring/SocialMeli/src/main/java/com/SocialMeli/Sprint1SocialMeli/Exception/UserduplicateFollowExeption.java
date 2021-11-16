package com.SocialMeli.Sprint1SocialMeli.Exception;

public class UserduplicateFollowExeption extends RuntimeException{

    public UserduplicateFollowExeption(Integer id) {
        super( "Ya se sigue al Vendedor " + id );
    }

}
