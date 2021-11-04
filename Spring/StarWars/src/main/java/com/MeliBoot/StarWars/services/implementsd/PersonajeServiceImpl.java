package com.MeliBoot.StarWars.services.implementsd;

import com.MeliBoot.StarWars.dtos.PersonajeDTO;
import com.MeliBoot.StarWars.models.Personaje;
import com.MeliBoot.StarWars.repositories.PersonajeRepository;
import com.MeliBoot.StarWars.services.PersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    PersonajeRepository personajeRepository;

    public void PersonajeService(PersonajeRepository personajeRepository){
        this.personajeRepository = personajeRepository;
    }

    public ResponseEntity<?> getPersonajes(){
        List<Personaje> personajesPorNombre = personajeRepository.getPersonajes();
            List<PersonajeDTO> personajeDTOS = personajesPorNombre.stream().map(PersonajeDTO::new).collect(Collectors.toList());
            return new ResponseEntity<>(personajeDTOS, HttpStatus.OK);

    }

    public ResponseEntity<?> getPersonajePorNombre(String nombre){
        List<Personaje> personajesPorNombre = personajeRepository.buscarPorNombre(nombre).stream().filter(x -> x.getName().contains(nombre)).collect(Collectors.toList());
      //  if(personajesPorNombre.size() > 0) {
           List<PersonajeDTO> personajeDTOS = personajesPorNombre.stream().map(PersonajeDTO::new).collect(Collectors.toList());
            return new ResponseEntity<>(personajeDTOS, HttpStatus.OK);
        //}
  //      return new ResponseEntity<>("El personaje no existe", HttpStatus.NOT_FOUND);
    }
}
