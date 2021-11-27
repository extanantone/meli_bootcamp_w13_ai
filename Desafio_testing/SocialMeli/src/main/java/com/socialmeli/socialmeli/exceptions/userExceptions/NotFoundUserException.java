package com.socialmeli.socialmeli.exceptions.userExceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundUserException extends RuntimeException {
    private int id;

    public NotFoundUserException(int id) {
        this.id = id;
    }
}
