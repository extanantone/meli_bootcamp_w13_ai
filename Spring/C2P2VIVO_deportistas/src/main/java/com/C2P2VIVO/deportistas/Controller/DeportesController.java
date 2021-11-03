package com.C2P2VIVO.deportistas.Controller;

import com.C2P2VIVO.deportistas.Classes.Deporte;
import com.C2P2VIVO.deportistas.Classes.Persona;
import com.C2P2VIVO.deportistas.DTO.DeportePersona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeportesController {
    @GetMapping("/findSports")
    ResponseEntity<List> findSports(){

        List<Deporte> deportes = new ArrayList<>();
        Deporte deporte = new Deporte("Karate",10);
        deportes.add(deporte);
        deportes.add(new Deporte("Futbol", 5));

        return new ResponseEntity<>(deportes, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    ResponseEntity<Integer> nivelDeporte(@PathVariable String name){
        List<Deporte> deportes = new ArrayList<>();
        Deporte deporte = new Deporte("Karate",10);
        deportes.add(deporte);
        deportes.add(new Deporte("Futbol", 5));

        Deporte deporteFound = deportes.stream().filter(
                deporteObj -> name.equals(deporteObj.getNombre())
        ).findAny().orElse(null);

        if( deporteFound != null){
            return new ResponseEntity<>(deporteFound.getNivel(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(0,HttpStatus.BAD_REQUEST);
        }


    }

    @GetMapping("/findSportsPersons")
    @ResponseBody
    public DeportePersona getData(){
        Deporte deporte = new Deporte("Karate",10);
        Persona persona = new Persona("Gabriel", "Suarez", 26);

        DeportePersona deportePersona = new DeportePersona();
        deportePersona.setNombreDeporte(deporte.getNombre());
        deportePersona.setNombrePersona(persona.getNombre());
        deportePersona.setApellidoPersona(persona.getApellido());

        return deportePersona;
    }
}
