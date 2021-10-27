package bootcamp.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Curriculum extends Documento {
    Persona persona;
    List<String> habilidades;
    //Persona persona = new Persona(39879820,"Pablo","Guayta");


    @Override
    public void imprimir() {
        System.out.println("Estoy imprimiendo un CV");

    }
}
