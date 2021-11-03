package com.bootcamp.C2P2EJ1.service;

import com.bootcamp.C2P2EJ1.dto.DTOPersonaDeportista;
import com.bootcamp.C2P2EJ1.model.Deporte;
import com.bootcamp.C2P2EJ1.model.persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DatosService {
    private List<Deporte> todosLosDeportes = new ArrayList<>();
    private List<persona> todasLasPersonas = new ArrayList<>();

    public DatosService() {
        Deporte basquet = new Deporte("Basquet", 1);
        Deporte futbol = new Deporte("Futbol", 2);
        Deporte halterofilia = new Deporte("Halterofilia", 3);
        Deporte volley = new Deporte("Volley", 1);

        List<Deporte> listaDeportes1, listaDeportes2;
        listaDeportes1 = new ArrayList<>();
        listaDeportes2 = new ArrayList<>();

        listaDeportes1.add(futbol);
        listaDeportes1.add(volley);

        listaDeportes2.add(halterofilia);
        listaDeportes2.add(basquet);

        todosLosDeportes.addAll(listaDeportes1);
        todosLosDeportes.addAll(listaDeportes2);

        persona p1 = new persona("Marina", "Santiso", 25, listaDeportes2);
        persona p2 = new persona("Fabrizio", "Nuñez", 24, listaDeportes1);
        persona p3 = new persona("Melisa", "Santiso", 24, listaDeportes1);
        persona p4 = new persona("Isabel", "Filippi", 24, listaDeportes2);

        todasLasPersonas.add(p1);
        todasLasPersonas.add(p2);
        todasLasPersonas.add(p3);
        todasLasPersonas.add(p4);
    }

    public List<Deporte> mostrarTodosLosDeportes() {
        return todosLosDeportes;
    }

    public ResponseEntity<Integer> mostrarDeporteParticular(String nombreDeporte) {
        return new ResponseEntity<Integer>(todosLosDeportes.stream().
                filter(deporte -> deporte.getNombre().equals(nombreDeporte))
                .mapToInt(Deporte::getNivel)
                .sum(), HttpStatus.OK);
    }

    public String obtenerNombreDeporte(List<Deporte> listaDeportes) {
        String nombreDeporte = "";
        for (Deporte deporte : listaDeportes) {
            nombreDeporte += " " + deporte.getNombre();
        }
        return nombreDeporte;
    }

    public List<DTOPersonaDeportista> mostrarPersonaDeportista() {
        List<DTOPersonaDeportista> listaPersonasDeportistas = new ArrayList<>();

        listaPersonasDeportistas = todasLasPersonas.stream().map(persona -> {
            return new DTOPersonaDeportista(persona.getNombre(), persona.getApellido(), obtenerNombreDeporte(persona.getDeportes()));
        }).collect(Collectors.toList());
        return listaPersonasDeportistas;
    }
}
