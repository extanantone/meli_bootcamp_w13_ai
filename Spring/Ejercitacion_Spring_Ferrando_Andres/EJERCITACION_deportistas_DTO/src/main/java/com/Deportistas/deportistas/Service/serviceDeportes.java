package com.Deportistas.deportistas.Service;

import com.Deportistas.deportistas.DTO.DeportistaDTO;
import com.Deportistas.deportistas.Model.Deporte;
import com.Deportistas.deportistas.Model.Deportista;
import com.Deportistas.deportistas.Model.Persona;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class serviceDeportes {

    private List<Deporte> listaDeportes = new ArrayList<>();
    private List<Deportista> listaDeportista = new ArrayList<>();
    private List<DeportistaDTO> listaDeportistasDTO = new ArrayList<>();

    public serviceDeportes()
    {
        cargarDeportes();
        asignarDeportes();
        personasDeportistas();
    }

    public void cargarDeportes()
    {
        String nombre = "Futbol";
        int nivel = 2;
        Deporte d1 = new Deporte(nombre,nivel);
        listaDeportes.add(d1);

        nombre = "Basquet";
        nivel = 1;
        Deporte d2 = new Deporte(nombre,nivel);
        listaDeportes.add(d2);

        nombre = "Tenis";
        nivel = 3;
        Deporte d3 = new Deporte(nombre,nivel);
        listaDeportes.add(d3);

        nombre = "Handball";
        nivel = 1;
        Deporte d4 = new Deporte(nombre,nivel);
        listaDeportes.add(d4);


    }



    public void asignarDeportes()
    {
        String nombre="Juan";
        String apellido="Perez";
        int edad=30;
        Persona p1= new Persona(nombre,apellido,edad);

        nombre="Lucas";
        apellido="Garcia";
        edad=72;
        Persona p2= new Persona(nombre,apellido,edad);

        nombre="Pedro";
        apellido="Gomez";
        edad=45;
        Persona p3= new Persona(nombre,apellido,edad);

        nombre="Santiago";
        apellido="Rodriguez";
        edad=10;
        Persona p4= new Persona(nombre,apellido,edad);



        listaDeportista.add(new Deportista(p1,listaDeportes.get(0)));
        listaDeportista.add(new Deportista(p2,listaDeportes.get(1)));
        listaDeportista.add(new Deportista(p3,listaDeportes.get(2)));
        listaDeportista.add(new Deportista(p4,listaDeportes.get(3)));

    }

    public int buscarDeporte(String deporte)
    {
        int nivel=-1;
        for(Deporte p : listaDeportes){
            if(p.getNombre().equals(deporte))
            {
                nivel=p.getNivel();
            }
        }

        return nivel;
    }

    public void personasDeportistas()
    {

        for (Deportista d : listaDeportista)
        {
            listaDeportistasDTO.add(new DeportistaDTO(d));

        }

    }


}
