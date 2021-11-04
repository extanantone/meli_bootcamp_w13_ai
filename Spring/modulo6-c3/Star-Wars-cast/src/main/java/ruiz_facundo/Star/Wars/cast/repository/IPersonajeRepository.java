package ruiz_facundo.Star.Wars.cast.repository;

import ruiz_facundo.Star.Wars.cast.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> buscarPersonajes(String inNombre);
}
