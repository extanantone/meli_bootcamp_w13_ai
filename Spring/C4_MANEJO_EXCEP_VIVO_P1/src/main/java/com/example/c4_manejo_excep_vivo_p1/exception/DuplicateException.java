package com.example.c4_manejo_excep_vivo_p1.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class DuplicateException extends RuntimeException
{
    private Long id;

    public DuplicateException(Long id)
    {
        this.id = id;
    }

}
