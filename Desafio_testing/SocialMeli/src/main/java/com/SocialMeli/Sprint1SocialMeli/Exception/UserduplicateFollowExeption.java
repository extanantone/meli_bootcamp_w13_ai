package com.SocialMeli.Sprint1SocialMeli.Exception;

public class UserduplicateFollowExeption extends RuntimeException {

    public UserduplicateFollowExeption(Integer id) {
        super("Ya  sigue al Vendedor " + id);
    }

}
