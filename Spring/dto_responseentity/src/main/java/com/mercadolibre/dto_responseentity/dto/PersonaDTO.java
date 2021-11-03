package com.mercadolibre.dto_responseentity.dto;

public class PersonaDTO {
    private String nombre;
    private String apellido;
    private int edad;
    private DeporteDTO deporte;

    public PersonaDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public PersonaDTO(String nombre, String apellido, int edad, DeporteDTO deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deporte = deporte;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public DeporteDTO getDeporte() {
        return deporte;
    }

    public void setDeporte(DeporteDTO deporte) {
        this.deporte = deporte;
    }

    @Override
    public String toString() {
        return "PersonaDTO{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", deporte=" + deporte +
                '}';
    }
}
