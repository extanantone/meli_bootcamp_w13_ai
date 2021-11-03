package com.example.deportistas.model;

public class Persona {

    private Long id;

    private String nombre;

    private String apellido;

    private Integer edad;

    private Deporte deporte;

    public Persona(Long id, String nombre, String apellido, Integer edad, Deporte deporte) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deporte = deporte;
    }

    public Persona() {

    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }
}
