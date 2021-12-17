package com.meliboopcamp.implementacionDB.c2Practica.service;

import com.meliboopcamp.implementacionDB.c2Practica.dtos.ActorDTO;
import com.meliboopcamp.implementacionDB.c2Practica.model.Actor;
import com.meliboopcamp.implementacionDB.c2Practica.repository.ActorRepositoryI;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArctorService {

    @Autowired
    ActorRepositoryI actorRepositoryI;

    ModelMapper mapper = new ModelMapper();

    public List<ActorDTO> obtenerAcvtorsFavoriteMoviesExist(){

        List<Actor>actors = actorRepositoryI.findActorByFavoriteMovieExists();

        //List<Actor>actors = (ArrayList<Actor>) actorRepositoryI.findActorByFirstNameEquals("Sam");

       List<ActorDTO> actorsdto= actors.stream().map(actor ->  mapper.map( actor, ActorDTO.class)).collect(Collectors.toList());

        return actorsdto;
    }
}
