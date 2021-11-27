package com.socialmeli.socialmeli.exceptions.userExceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExistingRelationshipException extends RuntimeException {
    private int id;
    private int id_to_follow;

    public ExistingRelationshipException(int id, int id_to_follow) {
        this.id = id;
        this.id_to_follow = id_to_follow;
    }
}
