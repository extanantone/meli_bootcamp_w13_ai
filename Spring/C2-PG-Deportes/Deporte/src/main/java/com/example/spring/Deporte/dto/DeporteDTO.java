package com.example.spring.Deporte.dto;

import java.io.Serializable;

public class DeporteDTO implements Serializable {

    private int nivel;

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
