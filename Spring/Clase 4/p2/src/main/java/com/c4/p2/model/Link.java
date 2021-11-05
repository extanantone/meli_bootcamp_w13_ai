package com.c4.p2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    Integer id;
    String url;
    Boolean invalido;
    Integer redirecciones;
    String pass;

    public void sumarRedireccion(){
        redirecciones += 1;
    }
}
