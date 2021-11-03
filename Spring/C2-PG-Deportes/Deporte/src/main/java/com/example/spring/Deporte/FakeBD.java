package com.example.spring.Deporte;

import com.example.spring.Deporte.models.Deporte;
import com.example.spring.Deporte.models.Persona;

import java.util.ArrayList;
import java.util.List;

public class FakeBD {

    public static List<Deporte> deportesDisponibles;
    public static List<Persona> atletas;


    public static void inicializarDeportesBD(){

        deportesDisponibles = new ArrayList<>();
        atletas = new ArrayList<>();

        Persona pablo = new Persona("Pablo","Guayta","Futbol",24);
        Persona rodri = new Persona("Rodrigo","Dimare","Basquet",24);

        Deporte futbol = new Deporte ("Futbol",1);
        Deporte tenis = new Deporte ("Tenis",2);
        Deporte basquet = new Deporte ("Basquet",3);

        deportesDisponibles.add(futbol);
        deportesDisponibles.add(tenis);
        deportesDisponibles.add(basquet);

        atletas.add(pablo);
        atletas.add(rodri);


    }



}
