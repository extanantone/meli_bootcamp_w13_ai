package com.MeliBoot.StarWars.services;

import org.springframework.http.ResponseEntity;

public interface PersonajeService {

    ResponseEntity<?> getPersonajePorNombre(String nombre);
    ResponseEntity<?> getPersonajes();


}
