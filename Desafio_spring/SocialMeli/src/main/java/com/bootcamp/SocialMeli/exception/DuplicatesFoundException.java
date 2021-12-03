package com.bootcamp.SocialMeli.exception;




public class DuplicatesFoundException extends RuntimeException {

    public DuplicatesFoundException(Integer id) {
        super( "Ya existe la publicacion con el ID: " + id  );
    }
}
