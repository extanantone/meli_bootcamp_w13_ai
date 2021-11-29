package com.SocialMeli.Sprint1SocialMeli.Exception;

public class UserNoFollowExeption extends RuntimeException {

    public UserNoFollowExeption(Integer vendedorid) {
        super("No sigue al Usuario " + vendedorid);
    }
}
