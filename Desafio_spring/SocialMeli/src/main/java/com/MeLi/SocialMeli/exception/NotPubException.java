package com.MeLi.SocialMeli.exception;

public class NotPubException extends Exception{
    public NotPubException(){
        super("No se pudo realizar la publicación.");
    }
}
