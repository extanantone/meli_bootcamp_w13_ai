package ruiz_facundo.Star.Wars.cast.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ruiz_facundo.Star.Wars.cast.dto.PersonajeDTO;
import ruiz_facundo.Star.Wars.cast.repository.IPersonajeRepository;
import ruiz_facundo.Star.Wars.cast.service.IPersonajeService;

import java.util.List;

@RestController
@RequestMapping("/api/personaje")
public class PersonajeController {
    IPersonajeService personajeService;

    public PersonajeController(IPersonajeService inPersonajeService) {
        this.personajeService = inPersonajeService;
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> getPersonajes(
            @PathVariable String nombre) {
        return new ResponseEntity<>(
                personajeService.obtenerPersonaje(nombre),
                HttpStatus.OK
        );
    }
}
