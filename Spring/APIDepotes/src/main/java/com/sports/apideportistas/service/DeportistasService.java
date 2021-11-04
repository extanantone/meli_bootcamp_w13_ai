package com.sports.apideportistas.service;

import com.sports.apideportistas.dto.DeporteDTO;
import com.sports.apideportistas.dto.DeportistaDTO;
import com.sports.apideportistas.repository.DeportistasRepositoryImp;
import com.sports.apideportistas.repository.IDeportistasRepository;

import java.util.List;

public class DeportistasService {

    private DeportistasRepositoryImp dp;

    public DeportistasService() {
        this.dp = new DeportistasRepositoryImp();;
    }

    public List<DeporteDTO> findSports() {
        return dp.findSports();
    }

    public DeporteDTO findSport(String nombreDeporte){
        return dp.findSport(nombreDeporte);
    }

    public List<DeportistaDTO> findSportsPersons(){
        return dp.findSportsPerson();
    }
}
