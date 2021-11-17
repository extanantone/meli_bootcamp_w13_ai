package com.example.socialmeli.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class UserNoFound extends RuntimeException{
    Integer i;

    public UserNoFound() {
    }

    public UserNoFound(String message) {
        super(message);
    }

    public UserNoFound(Integer i) {
        this.i = i;
    }




}
