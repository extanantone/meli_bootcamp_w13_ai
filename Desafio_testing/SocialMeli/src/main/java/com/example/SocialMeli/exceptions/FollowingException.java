package com.example.SocialMeli.exceptions;

import com.example.SocialMeli.exceptions.handler.SocialMeliException;
import org.springframework.http.HttpStatus;

public class FollowingException extends SocialMeliException {

    public FollowingException(int userId, int userIdToUnfollow) {
        super("El usuario "+userId+" no esta siguiendo a "+userIdToUnfollow, HttpStatus.BAD_REQUEST);
    }
}
