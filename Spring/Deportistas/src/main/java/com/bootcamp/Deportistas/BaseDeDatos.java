package com.bootcamp.Deportistas;

import com.bootcamp.Deportistas.model.Deporte;
import com.bootcamp.Deportistas.model.Deportista;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {
    public static List<Deporte> deporte =new ArrayList();
    public static List<Deportista> deportista=new ArrayList();

    public static void llenarBD(){
        deporte.add(new Deporte("Futbol",1));
        deporte.add(new Deporte("Baloncesto",2));
        deporte.add(new Deporte("Natacion",3));
        deportista.add(new Deportista("Mario","Forero",26));
        deportista.add(new Deportista("Pedro","Perez",24));
        deportista.add(new Deportista("Luna","Gomez",20));
    }
}
