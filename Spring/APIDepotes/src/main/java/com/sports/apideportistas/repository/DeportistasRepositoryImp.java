package com.sports.apideportistas.repository;

import com.sports.apideportistas.data.Data;
import com.sports.apideportistas.dto.DeporteDTO;
import com.sports.apideportistas.dto.DeportistaDTO;
import com.sports.apideportistas.model.Deporte;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DeportistasRepositoryImp implements IDeportistasRepository{

    private Data data;

    public DeportistasRepositoryImp() {
        this.data = new Data();
    }

    @Override
    public List<DeporteDTO> findSports() {

        List<DeporteDTO> deportes = new ArrayList<>();

        data.getDeportes().forEach((s, deporte) -> {
            deportes.add(new DeporteDTO(s,deporte.getNivel()));
        });

        return deportes;
    }

    @Override
    public DeporteDTO findSport(String nombre) {

        Deporte d = data.findSport(nombre);

        return new DeporteDTO(d.getNombreDeporte(),d.getNivel());
    }

    @Override
    public List<DeportistaDTO> findSportsPerson() {

        List<DeportistaDTO> deportistas = new ArrayList<>();

        data.getDeportistas().forEach((persona, deporte) -> {
            DeportistaDTO deportista = new DeportistaDTO(persona.getNombre(),persona.getApellido(),deporte.getNombreDeporte());
            deportistas.add(deportista);
        });
        return deportistas;
    }


}
