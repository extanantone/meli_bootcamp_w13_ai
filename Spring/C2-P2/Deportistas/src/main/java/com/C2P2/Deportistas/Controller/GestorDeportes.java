package com.C2P2.Deportistas.Controller;

import com.C2P2.Deportistas.DTOs.PersonaDeporteDTO;
import com.C2P2.Deportistas.Entidad.Deporte;
import com.C2P2.Deportistas.Entidad.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
public class GestorDeportes {

    private Deporte deporte1 = new Deporte("Futbol", 1);
    private Deporte deporte2 = new Deporte("Basket", 2);
    private Deporte deporte3 = new Deporte("Voley", 3);
    List<Deporte> deportes = List.of(deporte1, deporte2, deporte3);

    private Persona persona1 = new Persona("Nombre1", "Apellido1", 1, deporte1);
    private Persona persona2 = new Persona("Nombre2", "Apellido2", 2, deporte2);
    private Persona persona3 = new Persona("Nombre3", "Apellido3", 3, deporte3);
    List<Persona> personas = List.of(persona1, persona2, persona3);

    private PersonaDeporteDTO dto1, dto2, dto3;


    @GetMapping(path = "findSports")
    public List<Deporte> GetAllDeportes (){
            return deportes;

    }

    @GetMapping(path = "findSports/{name}")
    public Stream<Deporte> GetByNameDeportes (@PathVariable String name){

        //Deporte resultado = (Deporte) deportes.stream().filter(x -> x.getNombre() == name );

        return deportes.stream().filter(x -> x.getNombre() == name.toString());
    }

    @GetMapping(path = "findSportsPersons")
    public String GetAllPersonas (){

        return "hola";

    }

}
