package com.detectarDeportistas.ejercicioDeportistas.service;
import com.detectarDeportistas.ejercicioDeportistas.dto.DeportistaDTO;
import com.detectarDeportistas.ejercicioDeportistas.model.Deporte;
import com.detectarDeportistas.ejercicioDeportistas.model.Persona;

import java.util.ArrayList;
public class PersonaService {
    ArrayList<Persona> personas = new ArrayList<Persona>();
    ArrayList<Deporte> deportes = new ArrayList<Deporte>();
    ArrayList<DeportistaDTO> deportistasDTO = new ArrayList<DeportistaDTO>();
    DeporteService deporteService = new DeporteService();
    public PersonaService(){
        this.personas.add(new Persona("Jorge","Suarez"));
        this.personas.add(new Persona("Mariel","Dominguez"));
        this.personas.add(new Persona("Ariel","Juarez"));
        this.personas.add(new Persona("Susana","Gonzalez"));
        this.personas.add(new Persona("Pablo","Nuñez"));
        this.deportistasDTO.add(new DeportistaDTO(personas.get(0).getNombre(),personas.get(0).getApellido(),deporteService.getDeportes().get(0).getNombre()));
        this.deportistasDTO.add(new DeportistaDTO(personas.get(1).getNombre(),personas.get(1).getApellido(),deporteService.getDeportes().get(1).getNombre()));
        this.deportistasDTO.add(new DeportistaDTO(personas.get(2).getNombre(),personas.get(2).getApellido(),deporteService.getDeportes().get(2).getNombre()));
        this.deportistasDTO.add(new DeportistaDTO(personas.get(3).getNombre(),personas.get(3).getApellido(),deporteService.getDeportes().get(3).getNombre()));
        this.deportistasDTO.add(new DeportistaDTO(personas.get(4).getNombre(),personas.get(4).getApellido(),deporteService.getDeportes().get(0).getNombre()));
    }
    public ArrayList<DeportistaDTO> buscarDeportistas(){
        return this.deportistasDTO;
    }
}
