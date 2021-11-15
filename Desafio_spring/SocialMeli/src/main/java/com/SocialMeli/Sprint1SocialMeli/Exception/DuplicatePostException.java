package com.SocialMeli.Sprint1SocialMeli.Exception;

public class DuplicatePostException extends  RuntimeException {

    public DuplicatePostException(Integer id) {
        super( "YA EXISTE LA PUBLICACION: " + id+" !!!!" );
    }
}
