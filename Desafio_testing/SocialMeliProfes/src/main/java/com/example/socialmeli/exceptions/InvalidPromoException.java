package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidPromoException extends SocialMeliException{

    public InvalidPromoException(Integer idPost){
        super("LA PROMO CON EL ID "+ idPost + " NO ES VALIDA.", HttpStatus.BAD_REQUEST);
    }

}
