package com.example.socialmeli.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadRequestException extends RuntimeException
{
    private String msg;

    public BadRequestException(String msg)
    {
        this.msg = msg;
    }
}
