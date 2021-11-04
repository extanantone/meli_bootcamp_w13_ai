package com.sports.apideportistas.data;

import com.sports.apideportistas.model.Deporte;
import com.sports.apideportistas.model.Persona;

import java.util.HashMap;
import java.util.Map;

public class Data {


    private Map<String, Deporte> deportes;

    private Map<Persona, Deporte> deportistas;

    private Map<String, Persona> personas;


    public Data() {

        deportes = new HashMap<>();

        personas = new HashMap<>();

        deportistas = new HashMap<>();


        Deporte futbol = new Deporte("Futbol", 3);

        Deporte basketball = new Deporte("Basketball", 3);

        Deporte atletismo = new Deporte("Atletismo", 4);

        Deporte gimnasia = new Deporte("Gimnasia", 3);

        deportes.put(futbol.getNombreDeporte(),futbol);
        deportes.put(basketball.getNombreDeporte(), basketball);
        deportes.put(atletismo.getNombreDeporte(), atletismo);
        deportes.put(gimnasia.getNombreDeporte(),gimnasia);

        Persona j = new Persona("J" , "G",26);
        Persona p = new Persona("Pedro" , "Jimenez",18);
        Persona l = new Persona("L" , "Villareal",25);
        Persona z = new Persona("Jaime" , "Zapata",28);


        personas.put("Jimenez", j);
        personas.put("Jimenez", p);
        personas.put("Villareal", l);
        personas.put("Zapata", z);

        deportistas.put(j,basketball);
        deportistas.put(l,gimnasia);
        deportistas.put(p,futbol);
        deportistas.put(z,atletismo);

    }


    public Map<String, Deporte> getDeportes() {
        return deportes;
    }

    public Map<Persona, Deporte> getDeportistas() {
        return deportistas;
    }

    public Deporte findSport(String name){
        return deportes.get(name);
    }
}
