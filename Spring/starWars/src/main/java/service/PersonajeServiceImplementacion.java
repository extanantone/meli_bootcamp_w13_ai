package service;
import Repository.PersonajeRepository;
import dto.PersonajeDTO;
import model.Personaje;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
public class PersonajeServiceImplementacion implements PersonajeService{
    PersonajeRepository personajeRepository;
    public PersonajeServiceImplementacion(PersonajeRepository personajeRepository){
        this.personajeRepository = personajeRepository;
    }
    public ResponseEntity<?> listarPersonajes() {
        List<Personaje>personajesPorNombre = personajeRepository.getPersonajes();
        List<PersonajeDTO>personajeDTO = personajesPorNombre.stream().map(PersonajeDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(personajeDTO, HttpStatus.OK);
    }
    public ResponseEntity<?> getPersonajePorNombre(String nombre) {
        List<Personaje>personajesPorNombre = personajeRepository.buscarPorNombre(nombre);
        if(personajesPorNombre.size() > 0){
            List<PersonajeDTO> personajeDTOS = personajesPorNombre.stream().map(PersonajeDTO::new).collect(Collectors.toList());
            return new ResponseEntity<>(personajeDTOS,HttpStatus.OK);
        }
        return new ResponseEntity<>("El personaje no existe",HttpStatus.NOT_FOUND);
    }
}
