package com.bootcamp.SocialMeli.exception;

public class DuplicateIDPostException extends RuntimeException {

    public DuplicateIDPostException(int idPost, int userId) {
        super("La publicación " + idPost + " para el usuario " + userId + " ya se encuentra registrada en el sistema.");
    }
}