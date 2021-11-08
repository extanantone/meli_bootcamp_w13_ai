package com.example.c4_manejo_excep_vivo_p1.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NotFoundException extends RuntimeException
{
   private Long id;
}
