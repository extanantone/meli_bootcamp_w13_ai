package com.company;

import java.util.ArrayList;
import java.util.List;

public class PersonalMantenimiento extends Personal {
    List<String> herramientas;

    public PersonalMantenimiento(String nombre, String dni, String legajo, String ocupacion) {
        super(nombre, dni, legajo, ocupacion);
        herramientas = new ArrayList<>();
    }

    @Override
    void fichar() {
        System.out.println("El personal de mantenimiento está fichando");
    }

    public void ArreglarCosas() {
        System.out.println("El personal de mantenimiento está arreglando cosas");
    }

    public void ControlarCosas() {
        System.out.println("El personal de mantenimiento está controlando cosas");

    }

    public void TomarMates() {
        System.out.println("El personal de mantenimiento está tomando mates");

    }
}
