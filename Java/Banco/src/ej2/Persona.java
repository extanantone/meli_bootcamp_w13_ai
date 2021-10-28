package ej2;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    String name,surname,dni;
    List<String> habilidades;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDni() {
        return dni;
    }

    public Persona(String name, String surname, String dni) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.habilidades = new ArrayList<>();
    }
    public void agregarHabilidad(String habilidad){
        habilidades.add(habilidad);
    }
}
