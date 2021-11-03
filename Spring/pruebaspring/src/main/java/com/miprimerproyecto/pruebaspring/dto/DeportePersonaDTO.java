package com.miprimerproyecto.pruebaspring.dto;

import com.miprimerproyecto.pruebaspring.model.Deporte;
import com.miprimerproyecto.pruebaspring.model.Persona;
import com.miprimerproyecto.pruebaspring.model.PersonaDeporte;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

@Getter
@Setter
public class DeportePersonaDTO {

    List<Deporte> deporteList = new ArrayList<>();
    List<Persona> personaList = new ArrayList<>();
    List<PersonaDeporte> personaDeportes = new ArrayList<>();

    public int getDeporte(String nombre){

        if(deporteList.stream().filter(d-> d.getNombre().equals(nombre)).count()>0){

            for (Deporte d: deporteList) {
                if(d.getNombre().equals(nombre)){
                    return d.getNivel();
                }
            }
        }
        return 0;
    }

    public void addPersonaDeporte(PersonaDeporte personaDeporte){

        personaDeportes.add(personaDeporte);
    }

    public List<PersonaDeportistaDTO> getPesonaDeportistaDTO(){

        List<PersonaDeportistaDTO> personaDeportistaDTOS = new ArrayList<>();
        List <PersonaDeporte> personasfiltro = personaDeportes.stream().collect(
                collectingAndThen(
                        toCollection(() -> new TreeSet<>(comparingLong(PersonaDeporte::getIdPersona))), ArrayList::new)
        );

        for (PersonaDeporte pd: personasfiltro) {

           Persona p = personaList.stream().filter(persona -> persona.getId()==pd.getIdPersona()).findAny().get();
           List<String> deportes = new ArrayList<>();
                personaDeportes.stream().filter(pe -> pe.getIdPersona()== pd.getIdPersona()).forEach(
                        per-> {
                            deporteList.stream().filter(deporte -> deporte.getId()==per.getIdDeporte()).forEach(
                                    deporte -> {
                                        deportes.add(deporte.getNombre());
                                    }
                            );
                        }
                );

            PersonaDeportistaDTO personaDeportistaDTO = new PersonaDeportistaDTO();

           personaDeportistaDTO.setNombre(p.getNombre());
           personaDeportistaDTO.setApellido(p.getApellido());
           personaDeportistaDTO.setDeporte(deportes);

           personaDeportistaDTOS.add(personaDeportistaDTO);

        }

        return personaDeportistaDTOS;
    }

}
