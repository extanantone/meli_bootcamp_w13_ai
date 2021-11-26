package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidSortingCriteriaException extends SocialMeliException{
    public InvalidSortingCriteriaException(String order) {
        super("El criterio de ordenamiento " + order + " es inválido", HttpStatus.BAD_REQUEST);
    }
}
