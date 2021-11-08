package com.example.c4_man_excep_vivo_p1.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDTO
{
    private String name;
    private String msg;
}
