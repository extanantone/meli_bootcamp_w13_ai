package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PersonajeService;
@RestController
@RequestMapping("/api")
public class PersonajeController {
    @Autowired
    PersonajeService personajeService;

    public PersonajeController(PersonajeService personajeService){
        this.personajeService = personajeService;
    }
    @GetMapping("/personajes")
    public ResponseEntity<?> listarPersonajes(){
        return personajeService.getPersonajes();
    }

    @GetMapping("/personaje/{nombre}")
    public ResponseEntity<?> mostrarPersonaje(@PathVariable String nombre){
        return personajeService.getPersonajePorNombre(nombre);
    }
}
