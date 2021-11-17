package com.socialMeli.SocialMeli.exception.postExceptions;

public class ExistingPostException extends RuntimeException{
    public ExistingPostException() {
        super("Ya existe un post con ese id");
    }
}
