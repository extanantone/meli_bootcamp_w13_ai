package ruiz_facundo.Star.Wars.cast.service;

import org.springframework.stereotype.Service;
import ruiz_facundo.Star.Wars.cast.dto.PersonajeDTO;
import ruiz_facundo.Star.Wars.cast.model.Personaje;
import ruiz_facundo.Star.Wars.cast.repository.IPersonajeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService {
    IPersonajeRepository personajeRepository;

    public PersonajeService(IPersonajeRepository inPersonajeRepository) {
        this.personajeRepository = inPersonajeRepository;
    }

    @Override
    public List<PersonajeDTO> obtenerPersonaje(String inNombre) {
        List<Personaje> personajes = this.personajeRepository.
                buscarPersonajes(inNombre);
        return personajes.stream()
                .map( p -> new PersonajeDTO(p) )
                .collect(Collectors.toList());
    }
}
