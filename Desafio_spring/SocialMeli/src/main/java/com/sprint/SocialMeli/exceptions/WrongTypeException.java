package com.sprint.SocialMeli.exceptions;

// Indica si se pretenden realizar acciones de un usuario del perfil incorrecto (como por ejemplo, obtener la lista de seguidores de un comprador)
public class WrongTypeException extends Exception{

    public WrongTypeException(String message){
        super(message);
    }
}
