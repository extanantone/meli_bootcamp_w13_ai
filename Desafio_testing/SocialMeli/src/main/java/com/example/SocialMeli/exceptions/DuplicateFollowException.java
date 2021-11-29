package com.example.SocialMeli.exceptions;

import com.example.SocialMeli.exceptions.handler.SocialMeliException;
import org.springframework.http.HttpStatus;

public class DuplicateFollowException extends SocialMeliException {

    public DuplicateFollowException(int userId, int userFollowingId) {
        super("El usuario "+ userId + " ya esta siguiendo a "+userFollowingId, HttpStatus.BAD_REQUEST);
    }
}
