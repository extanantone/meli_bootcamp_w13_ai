package com.example.c2_dto_resp_ent_p2_vivo.controller;

import com.example.c2_dto_resp_ent_p2_vivo.C2DtoRespEntP2VivoApplication;
import com.example.c2_dto_resp_ent_p2_vivo.dto.SportPersonDTO;
import com.example.c2_dto_resp_ent_p2_vivo.model.Deporte;
import com.example.c2_dto_resp_ent_p2_vivo.model.Persona;
import com.example.c2_dto_resp_ent_p2_vivo.service.SeedServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.external.com.google.gdata.util.common.base.PercentEscaper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class SportsController
{

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> showSports()
    {
        List<Deporte> deportes = SeedServices.CreateDeportes();

        return new ResponseEntity<>(deportes, HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<String> getNivel(@PathVariable String name)
    {
        List<Deporte> deportes = SeedServices.CreateDeportes();

        Deporte foundSport = deportes.stream().filter((x) -> x.getNombre().equals(name)).findFirst().orElse(null);
        if (foundSport == null)
            return new ResponseEntity<>("No encontrado", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(foundSport.getNivel(), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<SportPersonDTO>> getPersons()
    {
        List<Persona> people = SeedServices.CreatePersonas();
        List<SportPersonDTO> result = new ArrayList<>();

        for (Persona person :people)
        {
            SportPersonDTO personDTO = new SportPersonDTO();
            personDTO.setNombre(person.getNombre());
            personDTO.setApellido(person.getApellido());
            personDTO.setNombreDeportes(person.getDeportes());
            result.add(personDTO);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
