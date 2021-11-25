package service;

import org.springframework.http.ResponseEntity;

public interface PersonajeService {
    ResponseEntity<?> listarPersonajes();
    ResponseEntity<?> getPersonajePorNombre(String nombre);
}
