package com.company.model;

import java.util.LinkedList;
import java.util.List;

public class Cliente {
    String nombre;
    List<Localizador> localizadores = new LinkedList<>();

    public Cliente(String nombre) {
        this.nombre = nombre;
    }


    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void addLocalizador(Localizador localizador) {
        this.localizadores.add(localizador);
    }
}
