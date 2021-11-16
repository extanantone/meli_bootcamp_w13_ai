package com.socialmeli.socialmeli.exceptions.userExceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnfollowYourselfException extends RuntimeException{
    private int id;

    public UnfollowYourselfException(int id) {
        this.id = id;
    }
}
