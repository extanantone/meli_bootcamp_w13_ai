package com.bootcamp.SocialMeli.exception;

public class DuplicateIdException extends RuntimeException{

    public DuplicateIdException(int id, String clase){super("Ya existe un "+clase+" con id:"+id);}

    public DuplicateIdException(int seguidor, int segido){super("Ya existe segidor id "+seguidor+" a seguido id:"+segido);}
}
