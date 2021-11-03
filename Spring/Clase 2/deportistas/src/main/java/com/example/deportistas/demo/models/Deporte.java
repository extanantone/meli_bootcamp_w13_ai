package com.example.deportistas.demo.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Deporte {

    int nivel;



    String deporte;

    public Deporte(int nivel, String deporte) {
        this.nivel = nivel;
        this.deporte = deporte;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
}
