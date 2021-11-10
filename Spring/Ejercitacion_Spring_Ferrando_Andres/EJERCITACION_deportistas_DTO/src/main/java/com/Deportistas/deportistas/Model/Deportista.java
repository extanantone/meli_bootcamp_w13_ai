package com.Deportistas.deportistas.Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Deportista {

    private Persona p;
    private Deporte d;

    public Deportista(Persona p, Deporte d) {
        this.p = p;
        this.d = d;
    }
}
