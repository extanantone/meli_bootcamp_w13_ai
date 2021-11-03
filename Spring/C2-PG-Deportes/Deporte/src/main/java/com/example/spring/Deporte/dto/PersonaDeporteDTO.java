package com.example.spring.Deporte.dto;

public class PersonaDeporteDTO {

    private String personaNombre;
    private String personaApellido;
    private String deporteNombre;


    public String getPersonaNombre() {
        return personaNombre;
    }

    public void setPersonaNombre(String personaNombre) {
        this.personaNombre = personaNombre;
    }

    public String getPersonaApellido() {
        return personaApellido;
    }

    public void setPersonaApellido(String personaApellido) {
        this.personaApellido = personaApellido;
    }

    public String getDeporteNombre() {
        return deporteNombre;
    }

    public void setDeporteNombre(String deporteNombre) {
        this.deporteNombre = deporteNombre;
    }
}
