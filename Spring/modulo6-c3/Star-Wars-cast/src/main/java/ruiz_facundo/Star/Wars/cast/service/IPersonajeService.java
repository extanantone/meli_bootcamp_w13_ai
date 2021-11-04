package ruiz_facundo.Star.Wars.cast.service;

import ruiz_facundo.Star.Wars.cast.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> obtenerPersonaje(String inNombre);
}
