package com.example.deportistas.dto;

import java.io.Serializable;

public class DeporteDTO  implements Serializable {
    private String nombre;
    private Integer nivel;

    public DeporteDTO() {
    }

    public DeporteDTO(String nombre, Integer nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
}
