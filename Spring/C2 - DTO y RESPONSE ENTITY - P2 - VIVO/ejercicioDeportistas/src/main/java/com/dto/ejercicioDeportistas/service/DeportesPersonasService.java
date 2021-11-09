package com.dto.ejercicioDeportistas.service;

import com.dto.ejercicioDeportistas.Deporte;
import com.dto.ejercicioDeportistas.Persona;
import com.dto.ejercicioDeportistas.dto.DeporteDTO;
import com.dto.ejercicioDeportistas.dto.PersonaDeporteDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class DeportesPersonasService {
    private List<Deporte> deportes;
    private List<Persona> personas;

    public DeportesPersonasService() {
        List<Deporte> sports = new ArrayList<>();
        sports.add(new Deporte("futbol", 5));
        sports.add(new Deporte("basquet", 4));
        sports.add(new Deporte("tenis", 3));
        this.deportes = sports;

        List<Persona> persons = new ArrayList<>();
        persons.add(new Persona("leo", "messi", 34));
        persons.add(new Persona("facundo", "campazzo", 30));
        persons.add(new Persona("diego", "schwartzman", 29));
        this.personas = persons;
    }

    public List<DeporteDTO> getAllDeportes(){
        List<DeporteDTO> deportes = new ArrayList<>();
        for (Deporte deporte:this.deportes){
            DeporteDTO deporteDTO = new DeporteDTO();
            deporteDTO.setNombre(deporte.getNombre());
            deporteDTO.setNivel(deporte.getNivel());
            deportes.add(deporteDTO);
        }
        return deportes;
    }

    public DeporteDTO findSportByName(String name){
        DeporteDTO deporteDTO = new DeporteDTO();
        Deporte deporteSearch = this.getDeportes().stream().filter(deporte -> deporte.getNombre().equals(name)).findAny().orElse(null);
        if(deporteSearch != null){
            deporteDTO.setNombre(deporteSearch.getNombre());
            deporteDTO.setNivel(deporteSearch.getNivel());
        }

        return deporteDTO;
    }

    public List<PersonaDeporteDTO> getDeportistas(){
        List<PersonaDeporteDTO> personsSports = new ArrayList<>();
        PersonaDeporteDTO personaDeporteDTO = new PersonaDeporteDTO();

        personaDeporteDTO.setDeporte(this.getDeportes().get(0).getNombre());
        personaDeporteDTO.setNombre(this.getPersonas().get(0).getNombre());
        personaDeporteDTO.setApellido(this.getPersonas().get(0).getApellido());
        personsSports.add(personaDeporteDTO);

        personaDeporteDTO = new PersonaDeporteDTO();
        personaDeporteDTO.setDeporte(this.getDeportes().get(1).getNombre());
        personaDeporteDTO.setNombre(this.getPersonas().get(1).getNombre());
        personaDeporteDTO.setApellido(this.getPersonas().get(1).getApellido());
        personsSports.add(personaDeporteDTO);

        personaDeporteDTO = new PersonaDeporteDTO();
        personaDeporteDTO.setDeporte(this.getDeportes().get(2).getNombre());
        personaDeporteDTO.setNombre(this.getPersonas().get(2).getNombre());
        personaDeporteDTO.setApellido(this.getPersonas().get(2).getApellido());
        personsSports.add(personaDeporteDTO);

        return personsSports;
    }
}
