package com.sports.apideportistas.repository;

import com.sports.apideportistas.dto.DeporteDTO;
import com.sports.apideportistas.dto.DeportistaDTO;

import java.util.List;

public interface IDeportistasRepository {

    List<DeporteDTO> findSports();

    DeporteDTO findSport(String nombre);

    List<DeportistaDTO> findSportsPerson();
}
