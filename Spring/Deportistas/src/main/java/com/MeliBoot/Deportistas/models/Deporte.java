package com.MeliBoot.Deportistas.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Setter
@Getter
public class Deporte {
    private String name;
    private int nivel;

    public Deporte() {
    }

    public Deporte(String name, int nivel) {
        this.name = name;
        this.nivel = nivel;
    }


}
