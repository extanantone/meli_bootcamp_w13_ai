package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Curriculum implements Documento{
    Persona persona = new Persona("Ruben");
    List habilidades = new ArrayList();

    public Curriculum() {
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
