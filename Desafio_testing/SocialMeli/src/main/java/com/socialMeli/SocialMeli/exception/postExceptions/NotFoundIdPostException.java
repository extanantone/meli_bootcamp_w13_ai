package com.socialMeli.SocialMeli.exception.postExceptions;

public class NotFoundIdPostException extends RuntimeException{
    public NotFoundIdPostException() {
        super("Id del post invalido");
    }
}
