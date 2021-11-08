package com.bootcamp.link_tracker.excepciones;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LinkInvalidoException extends RuntimeException{

    public LinkInvalidoException(String mensaje){
        super(mensaje);
    }

}
