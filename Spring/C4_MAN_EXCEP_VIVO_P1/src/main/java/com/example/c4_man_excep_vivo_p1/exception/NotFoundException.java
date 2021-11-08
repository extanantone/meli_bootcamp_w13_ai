package com.example.c4_man_excep_vivo_p1.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends RuntimeException
{
    private Integer linkId;

    public NotFoundException(Integer linkId)
    {
        this.linkId = linkId;
    }
}
