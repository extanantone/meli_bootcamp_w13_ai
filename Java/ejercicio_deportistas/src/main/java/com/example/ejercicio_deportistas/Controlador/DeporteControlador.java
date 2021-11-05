package com.example.ejercicio_deportistas.Controlador;

import com.example.ejercicio_deportistas.DTO.DeportistaDto;
import com.example.ejercicio_deportistas.Modelos.Deporte;
import com.example.ejercicio_deportistas.Modelos.Persona;
import com.example.ejercicio_deportistas.Servicios.DeporteServicio;
import com.example.ejercicio_deportistas.Servicios.PersonaServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class DeporteControlador {
    DeporteServicio depServ = new DeporteServicio();
    PersonaServicio perServ = new PersonaServicio();
    @GetMapping("/findSports")
    public ResponseEntity<HashMap<String,Integer>> buscarDeportes(){
        return new ResponseEntity<HashMap<String,Integer>>(depServ.getListaDeportes(),HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<Integer> buscarDeportes(@PathVariable String name){
        return new ResponseEntity<>(depServ.buscarNivelDeDeporte(name),HttpStatus.OK);
    }
    @PostMapping("/createSport")
    public ResponseEntity setDeporte(@RequestBody Deporte deporte){
        depServ.setDeporte(deporte);
        return new ResponseEntity("Se creo el deporte", HttpStatus.OK);
    }
    @PostMapping("/createPerson")
    public ResponseEntity setPerson(@RequestBody Persona persona){
        perServ.
        return new ResponseEntity("Se creo el deporte", HttpStatus.OK);
    }
    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDto> > consultarDeportistas(){
        List<DeportistaDto> deportistasDtoList = new ArrayList<>();
        perServ.getDeportistas().forEach(p -> deportistasDtoList.add(new DeportistaDto(p.getNombre(), p.getApellido(), p.getDeporte().getNombre())));
        if(deportistasDtoList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(deportistasDtoList, HttpStatus.OK);
    }
}
