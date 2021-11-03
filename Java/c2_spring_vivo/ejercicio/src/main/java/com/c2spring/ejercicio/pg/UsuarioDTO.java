package com.c2spring.ejercicio.pg;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UsuarioDTO implements Serializable {
    int id;
    String nombre;
    String apellido;
}
