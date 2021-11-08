package com.example.c4_manejo_excep_vivo_p1.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ErrorDTO
{
    private String name;
    private String msg;
}
