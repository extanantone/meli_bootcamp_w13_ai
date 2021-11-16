package com.ejerciciolinktracker.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Link {
    String url;
    Integer id;
    Integer cantUsos;
    int activo;

    public void aumentarCantidadUsos(){
        cantUsos++;
    }
}
