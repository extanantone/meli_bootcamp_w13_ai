package com.example.deportistas.demo;

import com.example.deportistas.demo.models.Deporte;
import com.example.deportistas.demo.models.Deportista;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BaseDeDatos {
    public static List<Deporte> deporte = new ArrayList<Deporte>();
    public static List<Deportista> deportista = new ArrayList<Deportista>();

    public static void llenarBD(){
        deporte.add(new Deporte(1, "Futbol"));
        deporte.add(new Deporte(2, "Natacion"));
        deporte.add(new Deporte(3, "Tenis"));
        deportista.add(new Deportista("pepito","perez",16));
        deportista.add(new Deportista("pepita","arango",18));
        deportista.add(new Deportista("juan","casti",21));

    }
}
