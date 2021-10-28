package com.MELI.repositories;

import com.MELI.models.Localizador;

import java.util.HashSet;
import java.util.Set;

public class LocalizadorRepositorio {
    Set<Localizador> localizadores;

    public LocalizadorRepositorio() {
        this.localizadores = new HashSet<>();
    }

    public void agregarLocalizador(Localizador localizador){
        localizadores.add(localizador);
    }
    
}
