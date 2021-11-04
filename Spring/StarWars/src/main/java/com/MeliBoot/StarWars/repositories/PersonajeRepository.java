package com.MeliBoot.StarWars.repositories;

import com.MeliBoot.StarWars.models.Personaje;
import java.util.List;

public interface PersonajeRepository {

    List<Personaje> getPersonajes();

    List<Personaje> buscarPorNombre(String nombre);

}
