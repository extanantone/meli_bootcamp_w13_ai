package ej2;

import java.util.ArrayList;
import java.util.List;

public class Curriculum extends Documentos{
    Persona persona;

    public Curriculum(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "persona=" + persona.getName() +
                "persona=" + persona.getSurname() +
                "persona=" + persona.getDni() +
                '}';
    }
}
