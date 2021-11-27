package com.socialmeli.socialmeli.exceptions.userExceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowYourselfException extends RuntimeException{
    private int id;

    public FollowYourselfException(int id) {
        this.id = id;
    }
}
