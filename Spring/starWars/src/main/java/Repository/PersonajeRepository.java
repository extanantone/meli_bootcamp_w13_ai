package Repository;

import model.Personaje;

import java.util.List;

public interface PersonajeRepository {
    List<Personaje> getPersonaje();
    List<Personaje> buscarPorNombre(String nombre);
}
