package com.C2P2.Deportistas.DTOs;

public class PersonaDeporteDTO {
    private String nombrePersona;
    private String apellidoPersona;
    private String nombreDeporte;

    public PersonaDeporteDTO(String nombrePersona, String apellidoPersona, String nombreDeporte) {
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.nombreDeporte = nombreDeporte;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }
}
