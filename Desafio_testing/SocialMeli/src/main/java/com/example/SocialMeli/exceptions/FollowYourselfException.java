package com.example.SocialMeli.exceptions;

import com.example.SocialMeli.exceptions.handler.SocialMeliException;
import org.springframework.http.HttpStatus;

public class FollowYourselfException extends SocialMeliException {

    public FollowYourselfException() {
        super("No se permite seguirse a si mismo", HttpStatus.BAD_REQUEST);
    }
}
