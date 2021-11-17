package com.socialMeli.SocialMeli.exception.userExceptions;

import lombok.Getter;

@Getter
public class NotFoundUserException extends RuntimeException{
    public NotFoundUserException() {
        super("Usuario no encontrado");
    }
}
