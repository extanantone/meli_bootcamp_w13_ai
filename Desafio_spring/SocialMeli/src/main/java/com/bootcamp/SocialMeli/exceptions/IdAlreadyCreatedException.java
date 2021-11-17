package com.bootcamp.SocialMeli.exceptions;

public class IdAlreadyCreatedException extends RuntimeException {
    public IdAlreadyCreatedException() {
    }

    public IdAlreadyCreatedException(String message) {
        super(message);
    }

}
