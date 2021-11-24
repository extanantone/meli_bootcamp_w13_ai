package com.deportistas.controllers;

import com.deportistas.entities.DTOPerson;
import com.deportistas.entities.DTOSport;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SportsController {
    private List<DTOSport> sports = new ArrayList<>();
    private List<DTOPerson> people = new ArrayList<>();

    @PostMapping(path = "/sports", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createSport(@RequestBody DTOSport newSport) {
        try {
            sports.add(newSport);
            return ResponseEntity.ok().body(
                    "El deporte " +
                            newSport.getName() +
                            " de nivel " +
                            newSport.getLevel() +
                            " fue correctamente agregado al sistema"
            );
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Los datos ingresados no son correctos");
        }
    }

    @GetMapping(path = "/sports")
    public ResponseEntity<List<DTOSport>> listSports() {
        return ResponseEntity.status(200).body(sports);
    }

    @PostMapping(path = "/people", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createPerson(@RequestBody DTOPerson newPerson) {
        for (DTOSport s : newPerson.getSports()) {
            System.out.println(s.getName() + " " + s.getLevel());
        }

        for (DTOSport s : sports) {
            System.out.println(s.getName() + " " + s.getLevel());
        }
        Boolean areSportsValid = true;

        for (DTOSport s : newPerson.getSports()) {
            for (DTOSport hola: sports.stream().filter(
                    sport -> sport.getName() == s.getName()
                            && sport.getLevel() == s.getLevel()).
                    collect(Collectors.toList())) {
                System.out.println(hola);
                areSportsValid = false;
            }
        }

        if (areSportsValid) {
            try {
                people.add(newPerson);
                return ResponseEntity.ok().body(
                        "La persona " +
                                newPerson.getName() +
                                newPerson.getLastName() +
                                " de edad " +
                                newPerson.getAge() +
                                " fue correctamente agregada al sistema"
                );
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Los datos ingresados no son correctos");
            }
        } else {
            return ResponseEntity.badRequest().body("Los deportes ingresados no son correctos");
        }
    }

    @GetMapping(path = "/people")
    public ResponseEntity<List<DTOPerson>> listPeople() {
        return ResponseEntity.status(200).body(people);
    }

    @GetMapping(path = "/sports/{name}")
    public ResponseEntity<String> findSportByName(@PathVariable String name) {
        List<DTOSport> matchingSports = sports.stream().filter(s -> s.getName().toUpperCase() == name.toUpperCase()).collect(Collectors.toList());

        if (matchingSports.isEmpty()) {
            return ResponseEntity.badRequest().body("No existe el deporte ingresado");
        } else {
            StringBuilder res = new StringBuilder();
            res.append("El deporte dado se practica en los siguientes niveles:\n");

            for (DTOSport s : matchingSports) {
                res.append(s.getLevel() + "\n");
            }
            return ResponseEntity.status(200).body(res.toString());
        }
    }

    @GetMapping(path = "/people/sports")
    public ResponseEntity<List<DTOPerson>> listAthletes() {
        return ResponseEntity.ok(people.stream().filter(p -> p.getSports().size() > 0).collect(Collectors.toList()));
    }
}
