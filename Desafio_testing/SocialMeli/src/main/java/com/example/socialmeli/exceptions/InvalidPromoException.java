package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidPromoException extends SocialMeliException{

    public InvalidPromoException(Integer idPost){
        super("La promo de id " + idPost + " no es válida.", HttpStatus.BAD_REQUEST);
    }

}
